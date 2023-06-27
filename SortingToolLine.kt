package sorting

import java.util.*

class SortingToolLine : SortingTool {
    private val lines = mutableListOf<String>()
    private val scanner = Scanner(System.`in`)
    override fun sort() {
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine())
        }
        val totalLines = lines.size
        val maxLength = lines.maxOf { it.length }
        val longestLines = lines.filter { it.length == maxLength }
        val times = longestLines.size
        val percentage = 100 * times / totalLines
        println("Total lines: $totalLines.")
        println("The longest line:")
        longestLines.sorted().forEach(::println)
        println("($times time(s), $percentage%).")
    }

}