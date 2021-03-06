package dev.talkischeap.smtp.commands

import dev.talkischeap.smtp.constants.SmtpStatus

internal class ExtendedHelloCommand(
    private val serverHost: String
) : Command {
    override val name: String = NAME

    override fun execute(arguments: CommandArguments): CommandResponse =
        when {
            arguments.empty() -> CommandResponse(SmtpStatus.PARAMETERS_SYNTAX_ERROR, "Syntax: EHLO <hostname>")
            else -> CommandResponse(SmtpStatus.REQUESTED_ACTION_COMPLETED, serverHost)
        }

    companion object {
        const val NAME: String = "EHLO"
    }
}