package dev.talkischeap.smtp.server.commands

sealed class SmtpCommand {
    abstract val name: String
}

object HelloCommand : SmtpCommand() {
    override val name: String = "HELLO"
}

object ExtendedHelloCommand : SmtpCommand() {
    override val name: String = "EHLO"
}

object MailCommand : SmtpCommand() {
    override val name: String = "MAIL"
}

object RecipientCommand : SmtpCommand() {
    override val name: String = "RCPT"
}

object DataCommand : SmtpCommand() {
    override val name: String = "DATA"
}

object ResetCommand : SmtpCommand() {
    override val name: String = "RSET"
}

object VerifyCommand : SmtpCommand() {
    override val name: String = "VRFY"
}

object ExpandCommand : SmtpCommand() {
    override val name: String = "EXPN"
}

object HelpCommand : SmtpCommand() {
    override val name: String = "HELP"
}

object NoopCommand : SmtpCommand() {
    override val name: String = "NOOP"
}

object QuitCommand : SmtpCommand() {
    override val name: String = "QUIT"
}