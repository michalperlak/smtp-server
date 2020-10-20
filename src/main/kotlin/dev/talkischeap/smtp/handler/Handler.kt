package dev.talkischeap.smtp.handler

internal interface Handler {
    fun handle(data: MessageData): Pair<MessageResponse, Handler>
}