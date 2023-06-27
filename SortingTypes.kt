package sorting

enum class SortingTypes(val string: String) {
    BY_COUNT("byCount"), NATURAL("natural");

    companion object {
        fun getSortingType(input: String): SortingTypes {
            for (type in SortingTypes.values()) {
                if (type.string == input) return type
            }
            throw RuntimeException("Wrong sorting type $input")
        }
    }
}