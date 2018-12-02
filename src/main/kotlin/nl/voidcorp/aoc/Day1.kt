package nl.voidcorp.aoc

class Day1 : DayBase(1) {
    override fun part1(list: List<String>) = list.map { it.toLong() }.sum().toString()

    override fun part2(list: List<String>): String {
        var count = 0L
        val seen = mutableListOf<Long>(0)
        while (true) {
            list.map { it.toLong() }.forEach {
                count += it
                if (seen.contains(count)) {
                    return count.toString()
                }
                seen += count
            }
        }
    }

}