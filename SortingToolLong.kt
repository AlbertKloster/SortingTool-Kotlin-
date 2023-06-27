package sorting

import java.util.*

class SortingToolLong(val isSortIntegers: Boolean) : SortingTool {
    private val numbers = mutableListOf<Long>()
    private val scanner = Scanner(System.`in`)
    override fun sort() {
        while (scanner.hasNext()) {
            numbers.addAll(scanner.next().split(Regex("\\s+")).map { it.toLong() })
        }
        val totalNumbers = numbers.size
        val greatestNumber = numbers.maxOf { it }
        val times = numbers.count { it == greatestNumber }
        val percentage = 100 * times / totalNumbers
        println("Total numbers: $totalNumbers.")
        if (isSortIntegers)
            println("Sorted data: ${numbers.sorted().joinToString(" ")}")
        else
            println("The greatest number: $greatestNumber ($times time(s), $percentage%).")
    }

}