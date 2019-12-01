package de.ddkfm.j2019.day01

import java.io.File
import kotlin.math.floor

fun main() {
    println("mass (100756) -> ${100756.getFuel()}")
    val file = File("src/main/resources/day01/input.txt")
    val masses = file.readLines()
    val sum = masses
        .mapNotNull { mass -> mass.toIntOrNull()?.getFuel() }
        .sum()
    println(sum)
}

fun Int.getFuel() : Int {
    return (floor(this / 3f) - 2).toInt()
}