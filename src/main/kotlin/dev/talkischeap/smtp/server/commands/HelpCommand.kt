package dev.talkischeap.smtp.server.commands

class HelpCommand: Command {
    override val name: String = "HELP"

    override fun execute(arguments: CommandArguments): CommandResponse {
        TODO("Not yet implemented")
    }
}