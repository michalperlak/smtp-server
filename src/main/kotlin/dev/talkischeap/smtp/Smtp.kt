package dev.talkischeap.smtp

import dev.talkischeap.nio.server.messages.InitMessage
import dev.talkischeap.smtp.constants.SmtpStatus
import java.nio.charset.Charset

internal object Smtp {
    fun initMessage(serverName: String, charset: Charset): InitMessage =
        InitMessage.fromString("${SmtpStatus.SERVICE_READY.code} $serverName${dev.talkischeap.smtp.Smtp.MESSAGE_END}", charset)

    const val MESSAGE_END = "\r\n"
}