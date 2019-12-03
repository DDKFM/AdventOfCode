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
    val steps = intersectPoints.map { it to (line0.stepsTo(it) to line1.stepsTo(it)) }
    println(steps)
    println(steps.map { it.second.first + it.second.second }.min())
}

fun List<Point>.stepsTo(p : Point) : Int {
    return this.subList(0, this.indexOf(p)).size + 1
}