package dev.talkischeap.smtp.server.commands

class MailCommand: Command {
    override val name: String = "MAIL"

    override fun execute(arguments: CommandArguments): CommandResponse {
        TODO("Not yet implemented")
    }
}