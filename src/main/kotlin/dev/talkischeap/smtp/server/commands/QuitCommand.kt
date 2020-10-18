package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.constants.SmtpStatus

class QuitCommand : Command {
    override val name: String = NAME

    override fun execute(arguments: CommandArguments): CommandResponse =
        CommandResponse(SmtpStatus.SERVER_CLOSING_TRANSMISSION_CHANNEL, "See you")

    companion object {
        const val NAME: String = "QUIT"
    }
}