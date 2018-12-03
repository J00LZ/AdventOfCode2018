package nl.voidcorp.aoc

import kotlin.system.measureTimeMillis

abstract class DayBase(private val date: Int) {
    val list: List<String> = getText(date)
    open fun run(): Long {
        println("### Day$date ###")
        val one = measureTimeMillis {
            println("Day $date, part 1: ${part1()}")
        }
        println("Day $date, part 1 time: ${one}ms")
        println()
        val two = measureTimeMillis {
            println("Day $date, part 2: ${part2()}")
        }

        println("Day $date, part 2 time: ${two}ms")
        println()
        println("Total time     ${one + two}ms")
        println()
        return one + two

    }

    abstract fun part1(): String
    abstract fun part2(): String

}