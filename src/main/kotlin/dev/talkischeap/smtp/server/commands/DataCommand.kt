package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.constants.SmtpStatus

class DataCommand: Command {
    override val name: String = NAME

    override fun execute(arguments: CommandArguments): CommandResponse =
            CommandResponse(SmtpStatus.START_MAIL_INPUT, "End data with <CR><LF>.<CR><LF>")

    companion object {
        const val NAME: String = "DATA"
    }
}