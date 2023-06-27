package sorting

import java.util.*
import kotlin.math.roundToLong

class SortingToolWord(val sortingType: SortingTypes) : SortingTool {
    private val words = mutableListOf<String>()
    private val scanner = Scanner(System.`in`)
    override fun sort() {
        while (scanner.hasNext()) {
            words.addAll(scanner.next().split(Regex("\\s+")))
        }

        println("Total words: ${words.size}.")
        when (sortingType) {
            SortingTypes.NATURAL -> println(sortNatural())
            SortingTypes.BY_COUNT -> println(sortByCount())
        }
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