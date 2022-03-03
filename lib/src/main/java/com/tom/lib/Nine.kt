package com.tom.lib

fun main() {
    val n = 30
    println((1..n).random())
    for (i in 2..9) {
        for (j in 1..9) {
            println("$i*$j=${if (i*j < 10) " " else ""}${i*j}")
        }
    }
}

class Nine {
}