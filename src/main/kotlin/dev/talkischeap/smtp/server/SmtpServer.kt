package dev.talkischeap.smtp.server

import dev.talkischeap.nio.server.config.ServerConfigurer
import dev.talkischeap.smtp.server.commands.parser.CommandParser
import dev.talkischeap.smtp.server.commands.parser.CommandProducers
import dev.talkischeap.smtp.server.handler.SmtpMessageHandler
import dev.talkischeap.smtp.server.handler.commands.CommandHandler
import dev.talkischeap.smtp.server.handler.data.DataHandler
import java.nio.charset.StandardCharsets

fun main() {
    val serverName = "test-server"
    val charset = StandardCharsets.UTF_8
    val commandProducers = CommandProducers(serverName)
    val commandParser = CommandParser(commandProducers, charset)
    val messageHandler = SmtpMessageHandler { CommandHandler(commandParser, { DataHandler(it, charset) }, charset) }
    val server = ServerConfigurer
        .fromHandler(messageHandler)
        .initMessage(Smtp.initMessage(serverName, charset))
        .port(1025)
        .configure()
    server.start()
}