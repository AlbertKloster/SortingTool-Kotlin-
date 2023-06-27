package sorting

import java.util.Scanner

fun main() {
    val numbers = mutableListOf<Int>()
    val scanner = Scanner(System.`in`)

    while (scanner.hasNext()) {
        numbers.addAll(scanner.next().split(Regex("\\s+")).map { it.toInt() })
    }

    println("Total numbers: ${numbers.size}.")
    println("The greatest number: ${numbers.maxOf { it }} (${numbers.count { it == numbers.maxOf { it } }} time(s)).")

}
