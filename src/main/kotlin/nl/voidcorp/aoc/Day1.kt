package nl.voidcorp.aoc

object Day1 : DayBase(1) {
    val longs = list.map { it.toLong() }
    val seen = mutableListOf<Long>(0).toHashSet()

    override fun part1() = longs.sum().toString()

    override fun part2(): String {
        //return 219.toString()
        var count = 0L
        while (true) {
            longs.forEach {
                count += it
                if (seen.contains(count)) {
                    return count.toString()
                }
                seen += count
            }
        }

    }

}