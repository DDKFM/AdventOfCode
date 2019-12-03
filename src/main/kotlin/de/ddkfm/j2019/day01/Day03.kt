package de.ddkfm.j2019.day01

import java.io.File
import kotlin.math.abs

fun main() {
    val fileLines = File("src/main/resources/day03/input.txt").readLines()
    val line0 = fileLines[0].toPoints()
    val line1 = fileLines[1].toPoints()
    val intersectPoints = line0.intersect(line1)
    val nullPoint = Point(0, 0)
    val distances = intersectPoints.map { it to it.distance(nullPoint)}
    println(distances)
    println(distances.minBy { it.second })
}

data class Point(val x : Int, val y : Int)
fun String.toPoints() : List<Point> {
    val instructions = this.split(",")
    var lastAnchor = Point(0, 0)
    val line = mutableListOf<Point>()
    for(instruction in instructions) {
        val direction = when(instruction.first()) {
            'R' -> {p : Point -> p.copy(x = p.x + 1)}
            'U' -> {p : Point -> p.copy(y = p.y + 1)}
            'D' -> {p : Point -> p.copy(y = p.y - 1)}
            'L' -> {p : Point -> p.copy(x = p.x - 1)}
            else -> { p : Point -> p}
        }
        val amount = instruction.substring(1).toInt()
        for(i in 0 until amount) {
            lastAnchor = direction(lastAnchor)
            line.add(lastAnchor)
        }
    }
    return line
}

infix fun Point.distance(p : Point) : Int {
    return abs(this.x - p.x) + abs(this.y - p.y)
}