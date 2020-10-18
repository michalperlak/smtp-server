package dev.talkischeap.smtp.server.handler.data

import dev.talkischeap.smtp.server.Smtp
import dev.talkischeap.smtp.server.commands.CommandResponse
import dev.talkischeap.smtp.server.constants.SmtpStatus
import dev.talkischeap.smtp.server.handler.Handler
import dev.talkischeap.smtp.server.handler.MessageData
import dev.talkischeap.smtp.server.handler.MessageResponse
import java.nio.charset.Charset

class DataHandler(
    private val commandHandler: Handler,
    private val charset: Charset
) : Handler {

    override fun handle(data: MessageData): Pair<MessageResponse, Handler> =
        when {
            shouldContinueDataCollection(data) -> continueDataCollection()
            else -> handleCommands()
        }

    private fun continueDataCollection(): Pair<MessageResponse, Handler> =
        null to this

    private fun handleCommands(): Pair<MessageResponse, Handler> =
        COLLECTION_FINISHED_RESPONSE.toByteArray(charset) to commandHandler

    private fun shouldContinueDataCollection(data: ByteArray): Boolean {
        val end = DATA_END.toByteArray(charset)
        if (data.size < end.size) {
            return true
        }
        val startIndex = data.size - end.size
        for (i in startIndex until data.size) {
            if (end[i - startIndex] != data[i]) {
                return true
            }
        }
        return false
    }

    companion object {
        private val COLLECTION_FINISHED_RESPONSE =
            CommandResponse(SmtpStatus.REQUESTED_ACTION_COMPLETED, "Ok").format()
        private const val DATA_END = "${Smtp.MESSAGE_END}.${Smtp.MESSAGE_END}"
    }
}