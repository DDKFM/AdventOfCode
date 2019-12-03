package de.ddkfm.j2019.day01

import java.io.File
import java.lang.Exception
import kotlin.math.floor

fun main() {
    val fileLines = File("src/main/resources/day03/input.txt").readLines()
    val line0 = "R75,D30,R83,U83,L12,D49,R71,U7,L72"//fileLines[0]
    val line1 = "U62,R66,U55,R34,D71,R55,D58,R83"//fileLines[1]
}

data class Point(val x : Int, val y : Int)
fun String.toLine() : List<Point> {
    val instructions = this.split(",")
    val nullPoint = Point(0, 0)
    return listOf()
}