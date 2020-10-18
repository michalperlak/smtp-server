package dev.talkischeap.smtp.server.handler.commands

import dev.talkischeap.smtp.server.commands.CommandResponse
import dev.talkischeap.smtp.server.commands.parser.CommandParser
import dev.talkischeap.smtp.server.constants.SmtpStatus
import dev.talkischeap.smtp.server.handler.Handler
import dev.talkischeap.smtp.server.handler.MessageData
import dev.talkischeap.smtp.server.handler.MessageResponse
import dev.talkischeap.smtp.server.handler.data.DataHandler
import java.nio.charset.Charset

class CommandHandler(
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