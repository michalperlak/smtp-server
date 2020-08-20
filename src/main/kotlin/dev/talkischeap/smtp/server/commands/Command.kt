package dev.talkischeap.smtp.server.commands

sealed class Command {
    abstract val name: String
}

object HelloCommand : Command() {
    override val name: String = "HELLO"
}

object ExtendedHelloCommand : Command() {
    override val name: String = "EHLO"
}

object MailCommand : Command() {
    override val name: String = "MAIL"
}

object RecipientCommand : Command() {
    override val name: String = "RCPT"
}

object DataCommand : Command() {
    override val name: String = "DATA"
}

object ResetCommand : Command() {
    override val name: String = "RSET"
}

object VerifyCommand : Command() {
    override val name: String = "VRFY"
}

object ExpandCommand : Command() {
    override val name: String = "EXPN"
}

object HelpCommand : Command() {
    override val name: String = "HELP"
}

object NoopCommand : Command() {
    override val name: String = "NOOP"
}

object QuitCommand : Command() {
    override val name: String = "QUIT"
}