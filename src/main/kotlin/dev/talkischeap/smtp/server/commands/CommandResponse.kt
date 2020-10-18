package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.Smtp
import dev.talkischeap.smtp.server.constants.SmtpStatus

data class CommandResponse(
    val status: SmtpStatus,
    val data: String
) {
    fun format(): String = "${status.code} $data${Smtp.MESSAGE_END}"
}