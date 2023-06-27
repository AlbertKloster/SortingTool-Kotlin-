package sorting

import java.io.File

class ReaderFile(private val filename: String): Reader {
    override fun read(): String {
        return File(filename).readText().trim()
    }
}