sealed class CharType : Comparator<Char> {
    abstract override fun compare(a: Char, b: Char): Int
}

object Lower : CharType() {
    override fun compare(a: Char, b: Char): Int {
        return when (charType(b)) {
            is Lower -> a - b
            else -> -1
        }
    }
}

object Upper : CharType() {
    override fun compare(a: Char, b: Char): Int {
        return when (charType(b)) {
            is Lower -> 1
            is Upper -> a - b
            is Num -> -1
        }

    }
}

object Num : CharType() {
    override fun compare(a: Char, b: Char): Int {
        return when (charType(b)) {
            is Num -> {
                val aInt = a - '0'
                val bInt = b - '0'
                val aEven = aInt % 2 == 0
                val bEven = bInt % 2 == 0

                return when {
                    aEven && bEven -> a - b
                    !aEven && !bEven -> a - b
                    aEven && !bEven -> -1
                    else -> 1
                }
            }
            else -> 1
        }
    }
}


fun sort(str: String) = str
        .toCharArray()
        .sortedWith(Comparator(::compareChar))
        .joinToString("")

fun charType(c: Char) = when {
    c.isLowerCase() -> Lower
    c.isUpperCase() -> Upper
    else -> Num
}

fun compareChar(a: Char, b: Char) = charType(a).compare(a, b)

fun main() {
    arrayOf(
            "ABCdefg1234567890",
            "Sorting123"
    )
            .map { sort(it) }
            .forEach { println(it) }
}
