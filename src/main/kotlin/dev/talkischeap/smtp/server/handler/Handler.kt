package dev.talkischeap.smtp.server.handler

interface Handler {
    fun handle(data: MessageData): Pair<MessageResponse, Handler>
}