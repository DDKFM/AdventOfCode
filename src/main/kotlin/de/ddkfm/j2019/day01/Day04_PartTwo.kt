package de.ddkfm.j2019.day01

import java.io.File
import kotlin.math.abs

fun main() {
    val min = 134792
    val max = 675810
    val count = (min..max).filter { p ->
        val hasAdjacentDigits = "(\\d)\\1+".toRegex().findAll("$p")
        val contains = hasAdjacentDigits.any { it.groups[0]?.value?.length == 2 }

        val digits = "$p".toCharArray().map { it.toString().toInt()}
        val increase = (0 until digits.size - 1)
            .mapIndexed { index: Int, _-> digits[index + 1] >= digits[index] }
            .reduce { acc, b -> acc && b }
        if(increase)
            println(increase)
        increase && contains
    }.count()
    println(count)
}
