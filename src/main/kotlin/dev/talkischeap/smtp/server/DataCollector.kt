package dev.talkischeap.smtp.server

class DataCollector {
    fun collect(data: ByteArray): Boolean {
        val content = String(data)
        println(content)
        val result = content.endsWith(MESSAGE_END)
        println(result)
        return result
    }

    companion object {
        private const val MESSAGE_END = "\r\n.\r\n"
    }
}