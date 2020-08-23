package dev.talkischeap.smtp.server.commands

class VerifyCommand: Command {
    override val name: String = "VRFY"

    override fun execute(arguments: CommandArguments): CommandResponse {
        TODO("Not yet implemented")
    }
}