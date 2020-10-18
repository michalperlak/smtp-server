package dev.talkischeap.smtp.server.commands.parser

import dev.talkischeap.smtp.server.commands.Command
import dev.talkischeap.smtp.server.commands.CommandArguments
import dev.talkischeap.smtp.server.commands.CommandResponse

sealed class ParseResult {
    fun executeOrHandle(errorHandler: (String) -> CommandResponse): CommandResponse =
        when (this) {
            is Success -> command.execute(arguments)
            is Error -> errorHandler(message)
        }

    companion object {
        fun success(command: Command, arguments: CommandArguments): ParseResult = Success(command, arguments)
        fun error(message: String): ParseResult = Error(message)
    }
}

internal data class Success(
    val command: Command,
    val arguments: CommandArguments
) : ParseResult()

internal data class Error(
    val message: String
) : ParseResult()
