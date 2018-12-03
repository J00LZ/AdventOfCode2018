package nl.voidcorp.aoc

import java.io.File
import java.io.FileReader
import java.io.FileWriter

fun getText(day: Int): List<String> {
    val f = File("data/day$day.txt")
    if (f.exists())
        return FileReader(f).readLines()
    if (!File(".cookie").exists()) {
        System.err.println("data/day$day.txt not found, as well as the cookie file!")
        System.err.println("Please either download the question yourself, or fill in your cookie!")
        System.exit(1)
    }
    val data = khttp.get(
        "https://adventofcode.com/2018/day/$day/input",
        cookies = mapOf("session" to FileReader(".cookie").readLines().first())
    ).text.split("\n").dropLast(1)
    val wr = FileWriter(f)
    data.forEach { wr.appendln(it) }
    wr.close()
    return data
    //return FileReader("data/day$day.txt").readLines()
}

/*val day2 = DayBase(2, { TODO("NYE") }) {
    TODO("NYE")
}

fun DayBase(
    date: Int,
    part1: (List<String>) -> String,
    part2: (List<String>) -> String
) = object : DayBase(date) {
    override fun part1(list: List<String>): String = part1(list)
    override fun part2(list: List<String>): String = part2(list)
}*/
