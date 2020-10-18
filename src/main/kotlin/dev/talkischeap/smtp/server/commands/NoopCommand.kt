package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.constants.SmtpStatus

class NoopCommand : Command {
    override val name: String = NAME

    override fun execute(arguments: CommandArguments): CommandResponse =
        CommandResponse(SmtpStatus.REQUESTED_ACTION_COMPLETED, "Ok")

    companion object {
        const val NAME: String = "NOOP"
    }
}