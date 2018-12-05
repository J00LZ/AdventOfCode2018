package nl.voidcorp.aoc

object Day5 : DayBase(5) {
    val str = list.first().toCharArray().toMutableList()
    override fun part1(): String {
        val polymer = list.first().toCharArray().toMutableList()

        return reacc(polymer).toString()

        //return polymer.joinToString(separator = "") { it.toString() }
        //return polymer.size.toString()
    }

    override fun part2(): String {
        val aa = mutableListOf<Char>().apply { addAll(str) }

        val bb = mutableListOf<Char>().apply { addAll(str) }
        val cc = mutableListOf<Char>().apply { addAll(str) }
        val dd = mutableListOf<Char>().apply { addAll(str) }
        aa.removeIf { it == 'a' || it == 'A' }
        bb.removeIf { it == 'b' || it == 'B' }
        cc.removeIf { it == 'c' || it == 'C' }
        dd.removeIf { it == 'd' || it == 'D' }
        return mutableListOf(reacc(aa), reacc(bb), reacc(cc), reacc(dd)).toString()
    }

    fun reacc(polymer: MutableList<Char>): Int {
        var alts = 1
        while (alts > 0) {
            alts = 0
            var i = 0
            var max = polymer.size - 1
            while (i < max) {
                if ((polymer[i].isUpperCase() &&
                            polymer[i + 1].isLowerCase()) ||
                    (polymer[i].isLowerCase() &&
                            polymer[i + 1].isUpperCase())
                ) {
                    if (polymer[i].toLowerCase() ==
                        polymer[i + 1].toLowerCase()
                    ) {
                        //println("${polymer[i]}&&${polymer[i + 1]}")

                        /*removableIndexes += i
                        removableIndexes += i + 1*/
                        polymer.removeAt(i + 1)
                        polymer.removeAt(i)
                        i -= 2
                        max = polymer.size - 1
                        alts++
                    }
                }
                i++
                if (i < 0) i = 0
            }

        }
        return polymer.size

    }
}