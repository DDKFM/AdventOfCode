package de.ddkfm.j2019.day01

import java.io.File
import kotlin.math.abs

fun main() {
    val min = 134792
    val max = 675810
    val count = (min..max).filter { p ->
        val hasAdjacentDigits = "\\d*(00|11|22|33|44|55|66|77|88|99)\\d*".toRegex().find("$p") != null
        val digits = "$p".toCharArray().map { it.toString().toInt()}
        val increase = (0 until digits.size - 1)
            .mapIndexed { index: Int, _-> digits[index + 1] >= digits[index] }
            .reduce { acc, b -> acc && b }
        if(increase)
            println(increase)
        increase && hasAdjacentDigits
    }.count()
    println(count)
}
