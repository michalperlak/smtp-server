package dev.talkischeap.smtp.server.commands

interface Command {
    val name: String

    fun execute(arguments: CommandArguments): CommandResponse
}