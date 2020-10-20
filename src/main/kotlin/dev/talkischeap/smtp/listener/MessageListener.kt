package dev.talkischeap.smtp.listener

interface MessageListener {
    fun onMessage(from: String, to: String, message: ByteArray)
}