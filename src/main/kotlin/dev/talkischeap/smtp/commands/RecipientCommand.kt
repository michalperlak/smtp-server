package dev.talkischeap.smtp.commands

import dev.talkischeap.smtp.constants.SmtpStatus

internal class RecipientCommand : Command {
    override val name: String = NAME

    override fun execute(arguments: CommandArguments): CommandResponse =
        CommandResponse(SmtpStatus.REQUESTED_ACTION_COMPLETED, "Ok")

    companion object {
        const val NAME: String = "RCPT"
    }
}