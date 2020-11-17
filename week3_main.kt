package week3

fun main() {
    //isFoo1(null) does not compile
    //isFoo2(null)
    isFoo3(null)
    isFoo4(null)


    val x: Int? = 1
    val y: Int = 2
    val sum = x ?: 0 + y
    println(sum)


    val s1: String? = null
    val s2: String? = ""
    println(s1.isEmptyOrNull()) //eq true
    println(s2.isEmptyOrNull()) //eq true

    val s3 = "   "
    println(s3.isEmptyOrNull()) //eq false


    val s = ""
    //println(s as? Int)    // null
    //println(s as Int?)    // exception


    val people = listOf(Person("Anna", 28),Person("Peter", 38), Person("Alex", 29))
    val oldest = findTheOldest(people)
    val oldest2 = findTheOldest2(people)
    println("Person found: ${oldest?.name} with ${oldest?.age} years old.")
    println("Person found: ${oldest2?.name} with ${oldest2?.age} years old.")


    println("\nDuplicate non zero elements:")
    println(duplicateNonZero(listOf(3,0,5)))
    println(duplicateNonZero2(listOf(3,0,5)))
}

fun foo(list1: List<Int?>, list2: List<Int>?){
    list1.size
    list2?.size
    val i: Int? = list1.get(0)
    val j: Int? = list2?.get(0)
}

/**
 * It should return true, if the string is null or empty.
 */
fun String?.isEmptyOrNull(): Boolean {
    return (this == "" || this == null)
}


data class Name(val value: String)

fun isFoo1(n: Name) = n.value == "foo"

//fun isFoo2(n: Name?) = n.value == "foo" Does not compile
fun isFoo3(n: Name?) = n != null && n.value == "foo"
fun isFoo4(n: Name?) = n?.value == "foo"



data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>): Person?{
    var maxAge = 0
    var oldest: Person? = null
    for (p in people){
        if (p.age > maxAge){
            oldest = p
            maxAge = p.age
        }
    }
    return oldest
}

fun findTheOldest2(people: List<Person>): Person? = people.maxByOrNull { it.age }


//It does not does what you expect.
//Returns from the fuction
fun duplicateNonZero(list: List<Int>): List<Int> {
    return list.flatMap {
        if (it == 0)
            return listOf() //return keyword makes return from a 'fun', in this case duplicateNonZero
        listOf(it,it)
    }
}

//Returns from the lambda
fun duplicateNonZero2(list: List<Int>): List<Int> {
    return list.flatMap pred@{
        if (it == 0)
            return@pred listOf() //annotation makes return from lambda expression
        listOf(it,it)
    }
}


//if one of the elements is zero, function stops printing
fun maybePrint(list: List<Int>){
    list.forEach {
        if (it == 0) return
        print(it)
    }
    println("####")
}

fun reallyPrint(list: List<Int>){
    list.forEach pred@{
        if (it == 0) return@pred //or "break"
        print(it)
    }
    println("####")
}

