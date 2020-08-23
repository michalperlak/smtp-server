package dev.talkischeap.smtp.server.constants

enum class SmtpStatus(
        val code: Int
) {
    REQUESTED_ACTION_COMPLETED(250),
    PARAMETERS_SYNTAX_ERROR(501)
}