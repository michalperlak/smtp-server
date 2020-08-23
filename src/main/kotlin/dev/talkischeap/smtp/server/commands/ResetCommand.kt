package dev.talkischeap.smtp.server.commands

class ResetCommand: Command {
    override val name: String = "RSET"

    override fun execute(arguments: CommandArguments): CommandResponse {
        TODO("Not yet implemented")
    }
}