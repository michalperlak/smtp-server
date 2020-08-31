package dev.talkischeap.smtp.server.handler

import dev.talkischeap.smtp.server.commands.CommandResponse
import dev.talkischeap.smtp.server.commands.parser.CommandParser
import dev.talkischeap.smtp.server.constants.SmtpStatus

class CommandHandler(
        private val commandParser: CommandParser
) {
    fun handle(data: ByteArray): CommandResponse =
            commandParser
                    .parse(data)
                    .executeOrHandle { CommandResponse(SmtpStatus.SYNTAX_ERROR, it) }
}