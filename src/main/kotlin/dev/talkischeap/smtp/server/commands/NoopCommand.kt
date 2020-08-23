package dev.talkischeap.smtp.server.commands

class NoopCommand: Command {
    override val name: String = "NOOP"
}