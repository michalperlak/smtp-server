package dev.talkischeap.smtp.server.constants

enum class SmtpStatus(
        val code: Int
) {
    SERVER_CLOSING_TRANSMISSION_CHANNEL(221),
    REQUESTED_ACTION_COMPLETED(250),
    CANNOT_VERIFY_USER(252),
    PARAMETERS_SYNTAX_ERROR(501)
}