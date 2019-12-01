package de.ddkfm.j2019.day01

import java.io.File
import kotlin.math.floor

fun main() {
    println("mass (100756) -> ${100756.getFuelRecursive()}")
    val file = File("src/main/resources/day01/input.txt")
    val masses = file.readLines()
    val sum = masses
        .mapNotNull { mass -> mass.toIntOrNull()?.getFuelRecursive() }
        .sum()
    println(sum)
}

fun Int.getFuelRecursive() : Int {
    val fuel = (floor(this / 3f) - 2).toInt()
    return when {
        fuel < 0 -> 0
        fuel >= 0 -> fuel + fuel.getFuelRecursive()
        else -> fuel
    }
}