package dev.talkischeap.smtp.commands

internal interface Command {
    val name: String

    fun execute(arguments: CommandArguments): CommandResponse
}