package dev.talkischeap.smtp.server.commands

class NoopCommand: Command {
    override val name: String = "NOOP"

    override fun execute(arguments: CommandArguments): CommandResponse {
        TODO("Not yet implemented")
    }
}