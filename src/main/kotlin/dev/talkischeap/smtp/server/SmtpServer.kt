package dev.talkischeap.smtp.server

import dev.talkischeap.nio.server.config.ServerConfigurer
import dev.talkischeap.nio.server.messages.InitMessage
import dev.talkischeap.smtp.server.commands.parser.CommandParser
import dev.talkischeap.smtp.server.commands.parser.CommandProducers

fun main() {
    val server = ServerConfigurer
        .fromHandler(SmtpMessageHandler(CommandParser(CommandProducers("test-server"))))
        .initMessage(InitMessage.fromString("220 localhost\r\n"))
        .port(1025)
        .configure()
    server.start()
}