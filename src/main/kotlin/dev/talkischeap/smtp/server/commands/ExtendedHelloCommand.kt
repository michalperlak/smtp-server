package dev.talkischeap.smtp.server.commands

class ExtendedHelloCommand: Command {
    override val name: String = "EHLO"

    override fun execute(arguments: CommandArguments): CommandResponse {
        TODO("Not yet implemented")
    }
}