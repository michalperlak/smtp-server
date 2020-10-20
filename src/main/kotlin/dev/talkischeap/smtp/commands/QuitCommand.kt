package dev.talkischeap.smtp.commands

import dev.talkischeap.smtp.constants.SmtpStatus

internal class QuitCommand : Command {
    override val name: String = NAME

    override fun execute(arguments: CommandArguments): CommandResponse =
        CommandResponse(SmtpStatus.SERVER_CLOSING_TRANSMISSION_CHANNEL, "See you")

    companion object {
        const val NAME: String = "QUIT"
    }
}