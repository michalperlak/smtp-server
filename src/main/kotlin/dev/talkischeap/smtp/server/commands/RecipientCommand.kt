package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.constants.SmtpStatus

class RecipientCommand: Command {
    override val name: String = "RCPT"

    override fun execute(arguments: CommandArguments): CommandResponse =
            CommandResponse(SmtpStatus.REQUESTED_ACTION_COMPLETED, "Ok")
}