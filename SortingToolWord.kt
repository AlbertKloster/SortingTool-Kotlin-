package sorting

import java.util.*

class SortingToolWord : SortingTool {
    private val words = mutableListOf<String>()
    private val scanner = Scanner(System.`in`)
    override fun sort() {
        while (scanner.hasNext()) {
            words.addAll(scanner.next().split(Regex("\\s+")))
        }
        val totalWords = words.size
        val maxLength = words.maxOf { it.length }
        val longestWords = words.filter { it.length == maxLength }
        val times = longestWords.size
        val percentage = 100 * times / totalWords
        println("Total words: $totalWords.")
        println("The longest word: ${longestWords.first()} ($times time(s), $percentage%).")
    }

}