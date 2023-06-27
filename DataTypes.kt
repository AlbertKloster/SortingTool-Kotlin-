package sorting

enum class DataTypes(val string: String) {
    LONG("long"), LINE("line"), WORD("word");

    companion object {
        fun getDataType(input: String): DataTypes {
            for (type in DataTypes.values()) {
                if (type.string == input.lowercase()) return type
            }
            throw RuntimeException("No data type defined!")
        }
    }
}