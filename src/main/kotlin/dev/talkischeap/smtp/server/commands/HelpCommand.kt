package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.constants.SmtpStatus

class HelpCommand: Command {
    override val name: String = "HELP"

    override fun execute(arguments: CommandArguments): CommandResponse =
            CommandResponse(SmtpStatus.HELP_RESPONSE, "")
}