package dev.talkischeap.smtp.commands

import dev.talkischeap.smtp.constants.SmtpStatus

internal class ExpandCommand : Command {
    override val name: String = NAME

    override fun execute(arguments: CommandArguments): CommandResponse =
        CommandResponse(SmtpStatus.CANNOT_VERIFY_USER, "Command disabled")

    companion object {
        const val NAME: String = "EXPN"
    }
}