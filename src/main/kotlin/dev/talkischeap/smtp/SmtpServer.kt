package dev.talkischeap.smtp

import dev.talkischeap.nio.server.Server
import dev.talkischeap.nio.server.config.ServerConfigurer
import dev.talkischeap.smtp.commands.parser.CommandParser
import dev.talkischeap.smtp.commands.parser.CommandProducers
import dev.talkischeap.smtp.handler.SmtpMessageHandler
import dev.talkischeap.smtp.handler.commands.CommandHandler
import dev.talkischeap.smtp.handler.data.DataHandler
import dev.talkischeap.smtp.listener.MessageListener
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

class SmtpServer(
    private val port: Int = DEFAULT_PORT,
    private val name: String = DEFAULT_NAME,
    private val charset: Charset = DEFAULT_CHARSET,
    private val listeners: List<MessageListener> = emptyList()
) {
    private val server: Server by lazy { initServer() }

    fun start() = server.start()

    private fun initServer(): Server {
        val commandParser = CommandParser.create(serverName = name, charset = charset)
        val handlerFactory = { CommandHandler(commandParser, { DataHandler(it, charset) }, charset) }
        val messageHandler = SmtpMessageHandler(handlerFactory)
        val initMessage = Smtp.initMessage(name, charset)
        return ServerConfigurer
            .fromHandler(messageHandler)
            .initMessage(initMessage)
            .port(port)
            .configure()
    }

    companion object {
        private const val DEFAULT_PORT = 25
        private const val DEFAULT_NAME = "localhost"
        private val DEFAULT_CHARSET = StandardCharsets.UTF_8
    }
}

fun main() {
    val server = SmtpServer(port = 1025, name = "test-server")
    server.start()
}