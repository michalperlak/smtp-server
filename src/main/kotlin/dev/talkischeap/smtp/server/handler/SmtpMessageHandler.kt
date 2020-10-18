package dev.talkischeap.smtp.server.handler

import dev.talkischeap.nio.server.messages.MessageHandler
import dev.talkischeap.smtp.server.commands.parser.CommandParser
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

typealias ConnectionId = String

class SmtpMessageHandler(
    private val commandParser: CommandParser
) : MessageHandler {
    private val connections: ConcurrentMap<ConnectionId, SmtpConnectionHandler> = ConcurrentHashMap()

    override fun handle(connectionId: String, data: ByteArray): ByteArray? {
        println(connectionId)
        val connectionHandler = connections.getOrPut(connectionId) { SmtpConnectionHandler(commandParser, DataCollector()) }
        val result = connectionHandler.handle(data)
        if (result != null) {
            print(String(result))
        }
        return result
    }
}