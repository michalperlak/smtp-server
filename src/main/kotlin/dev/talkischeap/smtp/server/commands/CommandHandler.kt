package dev.talkischeap.smtp.server.commands

interface CommandHandler {
    fun handle(command: Command): CommandResponse
}