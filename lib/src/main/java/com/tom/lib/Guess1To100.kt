package com.tom.lib

import kotlin.random.Random

fun main() {
    var min = 1
    var max = 100
    val secret = Random.nextInt(100)+1
    var num = 0
    println(secret)
    while(num != secret) {
        println("Please enter a number between $min to $max")
        readLine()?.let {
            num = it.toInt()
            if (num < secret) {
                min = num
            } else if (num > secret) {
                max = num
            } else {
                println("You got it, the secret number is $num")
            }
        }

    }
}


class Guess1To100 {
}