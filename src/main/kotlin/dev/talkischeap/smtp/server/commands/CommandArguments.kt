package dev.talkischeap.smtp.server.commands

class CommandArguments(
        private val arguments: List<String>
) {
    val size: Int = arguments.size

    fun get(index: Int): String? = arguments.getOrNull(index)
}