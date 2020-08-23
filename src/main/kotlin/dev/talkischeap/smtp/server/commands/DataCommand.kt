package dev.talkischeap.smtp.server.commands

class DataCommand: Command {
    override val name: String = "DATA"

    override fun execute(arguments: CommandArguments): CommandResponse {
        TODO("Not yet implemented")
    }
}