package dev.talkischeap.smtp.handler.commands

import dev.talkischeap.smtp.commands.CommandResponse
import dev.talkischeap.smtp.commands.parser.CommandParser
import dev.talkischeap.smtp.constants.SmtpStatus
import dev.talkischeap.smtp.handler.Handler
import dev.talkischeap.smtp.handler.MessageData
import dev.talkischeap.smtp.handler.MessageResponse
import dev.talkischeap.smtp.handler.data.DataHandler
import java.nio.charset.Charset

internal class CommandHandler(
    private val commandParser: CommandParser,
    private val dataHandlerFactory: (CommandHandler) -> DataHandler,
    private val charset: Charset
) : Handler {

    override fun handle(data: MessageData): Pair<MessageResponse, Handler> {
        val commandResponse = commandParser
            .parse(data)
            .executeOrHandle { CommandResponse(SmtpStatus.SYNTAX_ERROR, it) }
        return when (commandResponse.status) {
            SmtpStatus.START_MAIL_INPUT -> collectData(commandResponse)
            else -> continueCommandsProcessing(commandResponse)
        }
    }

    private fun collectData(commandResponse: CommandResponse): Pair<MessageResponse, Handler> =
        prepareResponse(commandResponse) to dataHandlerFactory(this)

    private fun continueCommandsProcessing(commandResponse: CommandResponse): Pair<MessageResponse, Handler> =
        prepareResponse(commandResponse) to this

    private fun prepareResponse(commandResponse: CommandResponse): MessageResponse =
        commandResponse
            .format()
            .toByteArray(charset)
}