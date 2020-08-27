package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.constants.SmtpStatus

class HelloCommand(
        private val serverHost: String
): Command {
    override val name: String = NAME

    override fun execute(arguments: CommandArguments): CommandResponse =
            when {
                arguments.empty() -> CommandResponse(SmtpStatus.PARAMETERS_SYNTAX_ERROR, "Syntax: HELO <hostname>")
                else -> CommandResponse(SmtpStatus.REQUESTED_ACTION_COMPLETED, serverHost)
            }

    companion object {
        const val NAME: String = "HELO"
    }
}