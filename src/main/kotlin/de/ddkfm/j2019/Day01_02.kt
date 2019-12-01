package de.ddkfm.j2019

import java.io.File
import kotlin.math.floor

fun main() {
    println("test: " + 100756.getFuelRecursive())
    val file = File("day01/input.txt")
    val masses = file.readLines()
    val sum = masses
        .mapNotNull { mass -> mass.toIntOrNull()?.getFuelRecursive() }
        .sum()
    println(sum)
}

fun Int.getFuelRecursive() : Int {
    val fuel = (floor(this / 3f) - 2).toInt()
    if(fuel < 0 )
        return 0
    return if(fuel >= 0)
        fuel + fuel.getFuelRecursive()
    else
        fuel
}