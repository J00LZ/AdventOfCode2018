package nl.voidcorp.aoc

object Day7 : DayBase(7) {
    val input = list.map { it[5] to it[36] }
    val chars = input.flatMap { it.toList() }.toSet().sorted().toList()
    val prereqs = input.groupBy { it.second }.map { it.key to it.value.map { it.first }.toSet() }.toMap()

    override fun part1(): String {
        val res = mutableListOf<Char>()
        while (res.size < chars.size) {
            res += chars.filterNot { res.contains(it) }
                .first { !prereqs.containsKey(it) || prereqs[it]!!.all { res.contains(it) } }
        }

        return res.joinToString("")
    }

    override fun part2(): String {
        val res = mutableListOf<Char>()
        var workers = 0
        var seconds = -1
        val count = mutableMapOf<Char, Int>()
        while (res.size < chars.size) {
            count.filterValues { it == seconds }.keys.sorted().apply {
                forEach { count.remove(it) }
                workers -= this.size
                res += this
            }

            chars.filterNot { res.contains(it) || count.keys.contains(it) }
                .filter { !prereqs.containsKey(it) || prereqs[it]!!.all { res.contains(it) } }
                .toSortedSet()
                .take(5 - workers)
                .apply {
                    workers += this.size
                }.forEach {
                    count[it] = (it - 'A' + 61) + seconds
                }

            seconds++
        }

        return seconds.toString()
    }


}