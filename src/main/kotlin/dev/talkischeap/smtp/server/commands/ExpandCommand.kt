package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.constants.SmtpStatus

class ExpandCommand: Command {
    override val name: String = "EXPN"

    override fun execute(arguments: CommandArguments): CommandResponse =
            CommandResponse(SmtpStatus.CANNOT_VERIFY_USER, "COMMAND DISABLED")
}