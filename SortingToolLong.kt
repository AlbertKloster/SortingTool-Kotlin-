package sorting

import kotlin.math.roundToLong

class SortingToolLong(private val parameters: Parameters) : SortingTool {
    override fun sort() {
        val strings = mutableListOf<String>()
        parameters.reader.read().split("\r\n").forEach { strings.addAll(it.trim().split(Regex("\\s+"))) }
        val numbers = getNumbers(strings)
        val builder = StringBuilder("Total numbers: ${numbers.size}.\n")
        when (parameters.sortingType) {
            SortingTypes.NATURAL -> builder.append(sortNatural(numbers))
            SortingTypes.BY_COUNT -> builder.append(sortByCount(numbers))
        }
        parameters.writer.write(builder.toString())
    }

    private fun getNumbers(strings: MutableList<String>): MutableList<Long> {
        val numbers = mutableListOf<Long>()
        strings.forEach {
            if (!it.matches(Regex("-?\\d+")))
                println("\"$it\" is not a long. It will be skipped.")
            else
                numbers.add(it.toLong())
        }
        return numbers
    }

    private fun sortNatural(numbers: MutableList<Long>) = "Sorted data: ${ numbers.sorted().joinToString(" ") }"

    private fun sortByCount(numbers: MutableList<Long>): String {
        val totalNumbers = numbers.size
        val builder = StringBuilder()
        numbers.sorted().distinct().map { it to numbers.count { n -> it == n } }.sortedBy { it.second }
            .forEach { builder.append("${it.first}: ${it.second} time(s), ${(100.0 * it.second / totalNumbers).roundToLong()}%\n") }
        return builder.toString()
    }

}