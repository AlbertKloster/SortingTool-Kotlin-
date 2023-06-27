package sorting

fun main(args: Array<String>) {
    val sortingTool = getSortingTool(args)
    sortingTool.sort()
}

private fun getSortingTool(args: Array<String>): SortingTool {
    val sortingType = getSortingType(args)
    val indexOfDataType = args.indexOf("-dataType")
    if (indexOfDataType < 0) return SortingToolWord(SortingTypes.NATURAL)
    if (indexOfDataType + 1 >= args.size) return SortingToolWord(SortingTypes.NATURAL)
    return when (DataTypes.getDataType(args[indexOfDataType + 1])) {
        DataTypes.LONG -> SortingToolLong(sortingType)
        DataTypes.LINE -> SortingToolLine(sortingType)
        DataTypes.WORD -> SortingToolWord(sortingType)
    }
}

private fun getSortingType(args: Array<String>): SortingTypes {
    val indexOfSortingType = args.indexOf("-sortingType")
    if (indexOfSortingType < 0) return SortingTypes.NATURAL
    if (indexOfSortingType + 1 >= args.size) return SortingTypes.NATURAL
    return SortingTypes.getSortingType(args[indexOfSortingType + 1])
}
