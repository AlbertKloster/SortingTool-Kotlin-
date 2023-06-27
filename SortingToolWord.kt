package sorting

import kotlin.math.roundToLong

class SortingToolWord(private val parameters: Parameters) : SortingTool {
    private val words = mutableListOf<String>()
    override fun sort() {
        parameters.reader.read().split("\r\n").forEach { words.addAll(it.trim().split(Regex("\\s+"))) }
        val builder = StringBuilder("Total words: ${words.size}.\n")
        when (parameters.sortingType) {
            SortingTypes.NATURAL -> builder.append(sortNatural())
            SortingTypes.BY_COUNT -> builder.append(sortByCount())
        }
        parameters.writer.write(builder.toString())
    }

    private fun sortNatural() = "Sorted data: ${words.sorted().joinToString(" ")}"

    private fun sortByCount(): String {
        val totalWords = words.size
        val builder = StringBuilder()
        words.sorted().distinct().map { it to words.count { n -> it == n } }.sortedBy { it.second }
            .forEach { builder.append("${it.first}: ${it.second} time(s), ${(100.0 * it.second / totalWords).roundToLong()}%\n") }
        return builder.toString()
    }

}