package sorting

fun main(args: Array<String>) {
    val sortingTool = getSortingTool(args)
    sortingTool.sort()
}

private fun getSortingTool(args: Array<String>): SortingTool {
    val indexOfDataType = args.indexOf("-dataType")
    if (indexOfDataType < 0) return SortingToolWord()
    if (indexOfDataType + 1 >= args.size) return SortingToolWord()
    return when (DataTypes.getDataType(args[indexOfDataType + 1])) {
        DataTypes.LONG -> SortingToolLong()
        DataTypes.LINE -> SortingToolLine()
        DataTypes.WORD -> SortingToolWord()
    }
}
