package dev.talkischeap.smtp.server.commands

class RecipientCommand: Command {
    override val name: String = "RCPT"

    override fun execute(arguments: CommandArguments): CommandResponse {
        TODO("Not yet implemented")
    }
}