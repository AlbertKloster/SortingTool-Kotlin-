package sorting

import kotlin.math.roundToLong

class SortingToolLine(private val parameters: Parameters) : SortingTool {
    private val lines = mutableListOf<String>()
    override fun sort() {
        parameters.reader.read().split("\n").forEach { lines.add(it.trim()) }
        val builder = StringBuilder("Total lines: ${lines.size}.\n")
        when (parameters.sortingType) {
            SortingTypes.NATURAL -> builder.append(sortNatural())
            SortingTypes.BY_COUNT -> builder.append(sortByCount())
        }
        parameters.writer.write(builder.toString())
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