package dev.talkischeap.smtp.server

import dev.talkischeap.smtp.server.commands.CommandResponse
import dev.talkischeap.smtp.server.commands.parser.CommandParser
import dev.talkischeap.smtp.server.constants.SmtpStatus

class SmtpConnectionHandler(
    private val commandParser: CommandParser,
    private val dataCollector: DataCollector
) {
    private var receivingData: Boolean = false

    fun handle(data: ByteArray): ByteArray? {
        if (receivingData) {
            receivingData = !dataCollector.collect(data)
            return if (!receivingData) "250 Ok\r\n".toByteArray() else null
        }
        val commandResponse = commandParser
            .parse(data)
            .executeOrHandle { CommandResponse(SmtpStatus.SYNTAX_ERROR, it)  }
        if (commandResponse.status == SmtpStatus.START_MAIL_INPUT) {
            receivingData = true
        }
        val response = commandResponse.format()
        return response.toByteArray()
    }
}