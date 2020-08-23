package dev.talkischeap.smtp.server.commands

class HelloCommand: Command {
    override val name: String = "HELLO"

    override fun execute(arguments: CommandArguments): CommandResponse {
        TODO("Not yet implemented")
    }
}