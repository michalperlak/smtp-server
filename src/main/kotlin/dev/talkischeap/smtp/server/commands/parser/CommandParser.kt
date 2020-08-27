package dev.talkischeap.smtp.server.commands.parser

import dev.talkischeap.smtp.server.commands.CommandArguments

class CommandParser(
        private val commandProducers: CommandProducers
) {
    fun parse(data: ByteArray): ParseResult {
        val fullCommand = String(data)
        val commandName = fullCommand.take(COMMAND_NAME_LENGTH)
        val commandProducer = commandProducers[commandName]
                ?: return ParseResult.error("Unrecognized command: $fullCommand")
        val arguments = parseArgs(fullCommand)
        return ParseResult.success(commandProducer.invoke(), arguments)
    }

    private fun parseArgs(fullCommand: String): CommandArguments =
            CommandArguments(
                    fullCommand
                            .drop(COMMAND_NAME_LENGTH)
                            .split("\\s+".toRegex())
                            .map(String::trim)
                            .filter(String::isNotBlank)
            )

    companion object {
        private const val COMMAND_NAME_LENGTH = 4
    }
}