package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.constants.SmtpStatus

class VerifyCommand: Command {
    override val name: String = "VRFY"

    override fun execute(arguments: CommandArguments): CommandResponse =
            CommandResponse(SmtpStatus.CANNOT_VERIFY_USER, "Command disabled")
}