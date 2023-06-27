package sorting

fun main(args: Array<String>) {
    checkUnknownCommandLineArguments(args)

    try {
        val sortingTool = getSortingTool(args)
        sortingTool.sort()
    } catch (e: RuntimeException) {
        println(e.message)
    }

}

private fun checkUnknownCommandLineArguments(args: Array<String>) {
    val commandLineArguments = args.filter { it.matches(Regex("-.+")) }
    commandLineArguments.forEach {
        if (!it.matches(Regex(CommandLineArguments.SORTING_TYPE.string + "|" +
                    CommandLineArguments.DATA_TYPE.string + "|" +
                    CommandLineArguments.INPUT_FILE.string + "|" +
                    CommandLineArguments.OUTPUT_FILE.string
            ))) {
            println("\"$it\" is not a valid parameter. It will be skipped.")
        }
    }
}

private fun getSortingTool(args: Array<String>): SortingTool {
    val sortingType = getSortingType(args)
    val indexOfDataType = args.indexOf(CommandLineArguments.DATA_TYPE.string)
    val reader = getReader(args)
    val writer = getWriter(args)
    if (indexOfDataType < 0) return SortingToolWord(Parameters(SortingTypes.NATURAL, reader, writer))
    if (indexOfDataType + 1 >= args.size) return throw RuntimeException("No data type defined!")
    return when (DataTypes.getDataType(args[indexOfDataType + 1])) {
        DataTypes.LONG -> SortingToolLong(Parameters(sortingType, reader, writer))
        DataTypes.LINE -> SortingToolLine(Parameters(sortingType, reader, writer))
        DataTypes.WORD -> SortingToolWord(Parameters(sortingType, reader, writer))
    }
}

private fun getSortingType(args: Array<String>): SortingTypes {
    val indexOfSortingType = args.indexOf(CommandLineArguments.SORTING_TYPE.string)
    if (indexOfSortingType < 0) return SortingTypes.NATURAL
    if (indexOfSortingType + 1 >= args.size) return throw RuntimeException("No sorting type defined!")
    return SortingTypes.getSortingType(args[indexOfSortingType + 1])
}

private fun getWriter(args: Array<String>): Writer {
    val indexOfOutputFile = args.indexOf(CommandLineArguments.OUTPUT_FILE.string)
    if (indexOfOutputFile < 0) return WriterConsole()
    if (indexOfOutputFile + 1 >= args.size) return throw RuntimeException("No output file defined!")
    return WriterFile(args[indexOfOutputFile + 1])
}

private fun getReader(args: Array<String>): Reader {
    val indexOfInputFile = args.indexOf(CommandLineArguments.INPUT_FILE.string)
    if (indexOfInputFile < 0) return ReaderConsole()
    if (indexOfInputFile + 1 >= args.size) return throw RuntimeException("No input file defined!")
    return ReaderFile(args[indexOfInputFile + 1])
}