package week2

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty() && args[0] != "") args[0] else "Kotlin"
    println("Hello ${name}!")

    println("The max between 2 and 4 is ${max(2,4)}")

    println(listOf("a", "b", "c").joinToString(
            "", "(", ")"
    ))

    displaySeparator('&', 2)

    println(updateWeather(10))
    println(updateWeather(20))
    println(updateWeather(30))

    printNextExpression("abc")

    print("Is 'a' a letter ? ")
    println(isLetter('a'))
    print("Is '1' a letter ? ")
    println(isLetter('1'))

    println("\nIs Valid Identifier Tests:")
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
    println(isValidIdentifier("_no$"))   // false

    val sum = listOf(1, 2, 3).sum()
    println(sum)    // 6

}

fun max(a: Int, b: Int): Int = if (a > b) a else b

fun displaySeparator(character: Char = '*', size: Int = 10){
    repeat(size) {
        print(character)
    }
    println()
}

fun updateWeather(degrees: Int): String {
    return when {
        degrees <= 20 -> "Good"
        degrees <= 10 -> "Cold"
        else -> "Hot"
    }
}

fun printNextExpression(str: String) {
    for(ch in str){
        print(ch + 1)
    }
    println()
}

fun isLetter(l: Char) = l in 'a'..'z' || l in 'A'..'Z'



/**
 * Implement the function that checks whether a string is a valid identifier.
 * A valid identifier is a non-empty string that starts with a letter or underscore
 * and consists of only letters, digits and underscores.
 */
fun isValidIdentifier(str: String): Boolean {
    if (str.isEmpty()){
        return false
    }

    if (str[0] != '_' && !isLetter(str[0])) {
        return false
    }

    for(ch in str.substring(1)){
        if (!isLetter(ch) && !ch.isDigit()){
            return false
        }
    }

    return true
}


fun String.lastChar() = this[this.length -1]

/*
fun sum(list: List<Int>): Int {
    var result = 0
    for (i in list) {
        result += i
    }
    return result
}*/

//same function as above but defined as an extension function
fun List<Int>.sum(): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}

