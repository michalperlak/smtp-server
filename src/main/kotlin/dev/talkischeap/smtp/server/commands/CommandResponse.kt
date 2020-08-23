package dev.talkischeap.smtp.server.commands

import dev.talkischeap.smtp.server.constants.SmtpStatus

data class CommandResponse(
        val status: SmtpStatus,
        val data: String
)