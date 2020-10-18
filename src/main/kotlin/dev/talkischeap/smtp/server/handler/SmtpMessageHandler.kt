package dev.talkischeap.smtp.server.handler

import dev.talkischeap.nio.server.messages.MessageHandler
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

typealias ConnectionId = String

typealias MessageResponse = ByteArray?

typealias MessageData = ByteArray

class SmtpMessageHandler(
    private val handlerFactory: () -> Handler
) : MessageHandler {
    private val connections: ConcurrentMap<ConnectionId, Handler> = ConcurrentHashMap()

    override fun handle(connectionId: String, data: MessageData): MessageResponse {
        val connectionHandler = connections.getOrPut(connectionId) { handlerFactory() }
        val (response, handler) = connectionHandler.handle(data)
        connections[connectionId] = handler
        return response
    }
}