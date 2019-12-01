package de.ddkfm.j2019

import java.io.File
import kotlin.math.floor

fun main() {
    println("test: " + 100756.getFuel())
    val file = File("day01/input.txt")
    val masses = file.readLines()
    val sum = masses
        .mapNotNull { mass -> mass.toIntOrNull()?.getFuel() }
        .sum()
    println(sum)
}

fun Int.getFuel() : Int {
    val fuel = (floor(this / 3f) - 2).toInt()
    return fuel
}