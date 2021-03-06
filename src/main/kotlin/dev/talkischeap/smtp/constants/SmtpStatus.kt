package dev.talkischeap.smtp.constants

internal enum class SmtpStatus(
    val code: Int
) {
    HELP_RESPONSE(214),
    SERVICE_READY(220),
    SERVER_CLOSING_TRANSMISSION_CHANNEL(221),
    REQUESTED_ACTION_COMPLETED(250),
    CANNOT_VERIFY_USER(252),
    START_MAIL_INPUT(354),
    SYNTAX_ERROR(500),
    PARAMETERS_SYNTAX_ERROR(501)
}