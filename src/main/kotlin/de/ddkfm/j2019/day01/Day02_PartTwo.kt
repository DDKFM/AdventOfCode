package de.ddkfm.j2019.day01

import java.io.File
import java.lang.Exception
import kotlin.math.floor

fun main() {
    val file = File("src/main/resources/day02/input.txt")

    val numbers = file.readText().split(",").map { it.toInt() }.toMutableList()
    for(noun in 0..99)
        for(verb in 0..99) {
            numbers[1] = noun
            numbers[2] = verb
            val completeResult = getOutput(mutableListOf(*numbers.toTypedArray()))
            println("n: $noun, v: $verb -> $completeResult")
            if(completeResult == 19690720) {
                println("***********n: $noun, v: $verb -> $completeResult************")
                break
            }
        }
}

fun getOutput(numbers : MutableList<Int>) : Int {
    var opcode = numbers.first()
    var currentOpcodeIndex = 0
    while(opcode < 99) {
        val pos1 = numbers[currentOpcodeIndex + 1]
        val pos2 = numbers[currentOpcodeIndex + 2]
        val posToStore = numbers[currentOpcodeIndex + 3]
        //println("p1: $pos1, p2: $pos2, endPos: $posToStore")
        val result = when(opcode) {
            1 -> numbers[pos1] + numbers[pos2]
            2 -> numbers[pos1] * numbers[pos2]
            else -> throw Exception("Junge, was ist falsch bei dir?")
        }
        numbers[posToStore] = result
        currentOpcodeIndex += 4
        opcode = numbers[currentOpcodeIndex]
    }
    return numbers.first()
}