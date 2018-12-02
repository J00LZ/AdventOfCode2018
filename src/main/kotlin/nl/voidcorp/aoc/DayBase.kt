package nl.voidcorp.aoc

abstract class DayBase(private val date: Int) {

    open fun run(list: List<String>) {
        println("Day $date, part 1: ${part1(list)}")
        println("Day $date, part 2: ${part2(list)}")
    }

    abstract fun part1(list: List<String>): String
    abstract fun part2(list: List<String>): String

}