package dev.talkischeap.smtp.server.commands.parser

import dev.talkischeap.smtp.server.commands.*

typealias CommandProducer = () -> Command

class CommandProducers(
    private val serverName: String
) {
    private val producers: Map<String, CommandProducer> = mapOf(
        DataCommand.NAME to ::DataCommand,
        ExpandCommand.NAME to ::ExpandCommand,
        ExtendedHelloCommand.NAME to { ExtendedHelloCommand(serverName) },
        HelloCommand.NAME to { HelloCommand(serverName) },
        HelpCommand.NAME to ::HelpCommand,
        MailCommand.NAME to ::MailCommand,
        NoopCommand.NAME to ::NoopCommand,
        QuitCommand.NAME to ::QuitCommand,
        RecipientCommand.NAME to ::RecipientCommand,
        ResetCommand.NAME to ::ResetCommand,
        VerifyCommand.NAME to ::VerifyCommand
    )

    operator fun get(commandName: String): CommandProducer? = producers[commandName]
}