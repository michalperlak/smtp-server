package dev.talkischeap.smtp.server.commands

class QuitCommand: Command {
    override val name: String = "QUIT"

    override fun execute(arguments: CommandArguments): CommandResponse {
        TODO("Not yet implemented")
    }
}