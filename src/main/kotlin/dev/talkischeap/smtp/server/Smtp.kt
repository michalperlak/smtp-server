package dev.talkischeap.smtp.server

import dev.talkischeap.nio.server.messages.InitMessage
import dev.talkischeap.smtp.server.constants.SmtpStatus
import java.nio.charset.Charset

object Smtp {
    fun initMessage(serverName: String, charset: Charset): InitMessage =
        InitMessage.fromString("${SmtpStatus.SERVICE_READY.code} $serverName$MESSAGE_END", charset)

    const val MESSAGE_END = "\r\n"
}