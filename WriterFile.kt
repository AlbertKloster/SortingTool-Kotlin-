package sorting

import java.io.File

class WriterFile(private val filename: String): Writer {
    override fun write(text: String) {
        File(filename).writeText(text)
    }
}