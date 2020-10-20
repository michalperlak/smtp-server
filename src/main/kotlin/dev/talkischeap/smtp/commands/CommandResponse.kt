package dev.talkischeap.smtp.commands

import dev.talkischeap.smtp.constants.SmtpStatus

internal data class CommandResponse(
    val status: SmtpStatus,
    val data: String
) {
    fun format(): String = "${status.code} $data${dev.talkischeap.smtp.Smtp.MESSAGE_END}"
}