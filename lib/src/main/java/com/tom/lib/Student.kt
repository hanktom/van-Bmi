package com.tom.lib

class Student constructor(
    var name: String,
    var english:Int,
    var math:Int) {
    //Fields
    //var name: String? = null
    //var english = 0
    //var math = 0
    //Methods
    fun print() {
        println("$name\t$english\t$math\t${average()}")
    }
    fun average() : Int {
        return (english+math)/2
    }
}

fun main() {
    val jack = Student("Jack", 85, 65)
    //jack.
    //jack.english = 85
    //jack.math = 65
    //println("${jack.name}\t${jack.english}\t${jack.math}")
    jack.print()
}