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
        if (!it.matches(Regex("-sortingType|-dataType")))
            println("\"$it\" is not a valid parameter. It will be skipped.")
    }
}

private fun getSortingTool(args: Array<String>): SortingTool {
    val sortingType = getSortingType(args)
    val indexOfDataType = args.indexOf("-dataType")
    if (indexOfDataType < 0) return SortingToolWord(SortingTypes.NATURAL)
    if (indexOfDataType + 1 >= args.size) return throw RuntimeException("No data type defined!")
    return when (DataTypes.getDataType(args[indexOfDataType + 1])) {
        DataTypes.LONG -> SortingToolLong(sortingType)
        DataTypes.LINE -> SortingToolLine(sortingType)
        DataTypes.WORD -> SortingToolWord(sortingType)
    }
}

private fun getSortingType(args: Array<String>): SortingTypes {
    val indexOfSortingType = args.indexOf("-sortingType")
    if (indexOfSortingType < 0) return SortingTypes.NATURAL
    if (indexOfSortingType + 1 >= args.size) return throw RuntimeException("No sorting type defined!")
    return SortingTypes.getSortingType(args[indexOfSortingType + 1])
}
