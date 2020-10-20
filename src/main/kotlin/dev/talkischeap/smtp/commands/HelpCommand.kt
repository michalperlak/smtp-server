package dev.talkischeap.smtp.commands

import dev.talkischeap.smtp.constants.SmtpStatus

internal class HelpCommand : Command {
    override val name: String = NAME

    override fun execute(arguments: CommandArguments): CommandResponse =
        CommandResponse(SmtpStatus.HELP_RESPONSE, "")

    companion object {
        const val NAME: String = "HELP"
    }
}