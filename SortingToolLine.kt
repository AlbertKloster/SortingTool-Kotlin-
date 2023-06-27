package sorting

import java.util.*
import kotlin.math.roundToLong

class SortingToolLine(val sortingType: SortingTypes) : SortingTool {
    private val lines = mutableListOf<String>()
    private val scanner = Scanner(System.`in`)
    override fun sort() {
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine())
        }
        println("Total lines: ${lines.size}.")
        when (sortingType) {
            SortingTypes.NATURAL -> println(sortNatural())
            SortingTypes.BY_COUNT -> println(sortByCount())
        }
    }

    private fun sortNatural() = "Sorted data: \n${lines.sorted().sortedBy { -it.length }.joinToString("\n")}"

    private fun sortByCount(): String {
        val totalLines = lines.size
        val builder = StringBuilder()
        lines.sorted().distinct().map { it to lines.count { n -> it == n } }.sortedBy { it.second }
            .forEach { builder.append("${it.first}: ${it.second} time(s), ${(100.0 * it.second / totalLines).roundToLong()}%\n") }
        return builder.toString()
    }

}