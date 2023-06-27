package sorting

import java.util.*
import kotlin.math.roundToLong

class SortingToolLong(private val sortingType: SortingTypes) : SortingTool {
    private val numbers = mutableListOf<Long>()
    private val scanner = Scanner(System.`in`)
    override fun sort() {
        while (scanner.hasNext()) {
            numbers.addAll(scanner.next().split(Regex("\\s+")).map { it.toLong() })
        }
        println("Total numbers: ${numbers.size}.")
        when (sortingType) {
            SortingTypes.NATURAL -> println(sortNatural())
            SortingTypes.BY_COUNT -> println(sortByCount())
        }
    }

    private fun sortNatural() = "Sorted data: ${numbers.sorted().joinToString(" ")}"

    private fun sortByCount(): String {
        val totalNumbers = numbers.size
        val builder = StringBuilder()
        numbers.sorted().distinct().map { it to numbers.count { n -> it == n } }.sortedBy { it.second }
            .forEach { builder.append("${it.first}: ${it.second} time(s), ${(100.0 * it.second / totalNumbers).roundToLong()}%\n") }
        return builder.toString()
    }

}