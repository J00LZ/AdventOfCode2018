package nl.voidcorp.aoc

object Day4 : DayBase(4) {
    val sortedList = list.toSortedSet()
    val gmap = mutableMapOf<Int, Int>()

    override fun part1(): String {

        var currentGuard = -123
        var slep = 0
        var wake = 0
        for (l in sortedList) {
            when {
                l.contains("Guard") -> {
                    if (currentGuard != -123) {
                        gmap[currentGuard] = gmap[currentGuard]!! + (wake - slep)
                    }
                    currentGuard = l.split("#").last().split(" ").first().toInt()

                    if (gmap[currentGuard] == null) {
                        gmap[currentGuard] = 0
                    }
                }
                l.contains("asleep") -> slep = l.split("]").first().split(":").last().toInt()
                l.contains("wakes") -> wake = l.split("]").first().split(":").last().toInt()
            }

        }

        val guard = gmap.maxBy { it.value }!!.key
        val asleepMap = mutableMapOf<Int, Int>()
        currentGuard = -123
        for (l in sortedList) {
            if (l.contains("Guard")) {
                if (currentGuard == guard) {
                    for (i in slep until wake) {
                        if (asleepMap[i] == null) {
                            asleepMap[i] = 0
                        }
                        asleepMap[i] = asleepMap[i]!! + 1
                        //println("$i=${asleepMap[i]}")
                    }
                }
                currentGuard = l.split("#").last().split(" ").first().toInt()
                gmap[currentGuard] = 0
            } else if (l.contains("asleep")) {
                slep = l.split("]").first().split(":").last().toInt()
            } else if (l.contains("wakes")) {
                wake = l.split("]").first().split(":").last().toInt()
            }
        }

        val maxSleep = asleepMap.maxBy { it.value }!!.key
        return "Guard #$guard * 00:$maxSleep = ${guard * maxSleep}"
    }

    override fun part2(): String {
        val m = mutableMapOf<Int, MutableList<Int>>().toSortedMap()
        for (g in gmap.keys) {
            m[g] = MutableList(100) { 0 }
        }
        var currentGuard = -123
        var slep = 0
        for (l in sortedList) {
            when {
                l.contains("Guard") -> {

                    currentGuard = l.split("#").last().split(" ").first().toInt()
                }
                l.contains("asleep") -> slep = l.split("]").first().split(":").last().toInt()
                l.contains("wakes") -> {
                    if (currentGuard != -123) {
                        for (i in slep until l.split("]").first().split(":").last().toInt()) {
                            m[currentGuard]!![i]++

                        }
                    }
                }
            }

        }


        val meme = m.mapValues { it.value.max()!! }.maxBy { it.value }!!

        var minute = 0

        m.forEach { t, u ->
            u.forEachIndexed { index, i ->
                if (i == meme.value) {
                    minute = index
                }
            }
        }

        return "Guard #${meme.key} * $minute = ${minute * meme.key}"

    }


}