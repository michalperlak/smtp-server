package dev.talkischeap.smtp.commands

internal class CommandArguments(
    private val arguments: List<String>
) {
    fun empty(): Boolean = arguments.isEmpty()

    fun get(index: Int): String? = arguments.getOrNull(index)
}