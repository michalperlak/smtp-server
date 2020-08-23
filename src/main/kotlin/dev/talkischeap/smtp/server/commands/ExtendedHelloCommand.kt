package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.constants.SmtpStatus

class ExtendedHelloCommand(
        private val serverHost: String
): Command {
    override val name: String = "EHLO"

    override fun execute(arguments: CommandArguments): CommandResponse =
            when {
                arguments.empty() -> CommandResponse(SmtpStatus.PARAMETERS_SYNTAX_ERROR, "Syntax: EHLO <hostname>")
                else -> CommandResponse(SmtpStatus.REQUESTED_ACTION_COMPLETED, serverHost)
            }
}