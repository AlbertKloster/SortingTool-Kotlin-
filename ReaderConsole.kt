package sorting

import java.util.Scanner

class ReaderConsole: Reader {
    override fun read(): String {
        val scanner = Scanner(System.`in`)
        val builder = StringBuilder()
        while (scanner.hasNext()) {
            builder.append(scanner.nextLine())
            builder.append("\n")
        }
        return builder.toString().trim()
    }
}
