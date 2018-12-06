package nl.voidcorp.aoc

import java.util.HashMap


object Day6 : DayBase(6) {
    var maxx = 0
    var maxy = 0
    val points = mutableListOf<Point>()

    override fun part1(): String {
        for (str in list) {
            val p = Point(str)
            points += p
            if (p.x > maxx) {
                maxx = p.x
            }
            if (p.y > maxy) {
                maxy = p.y
            }
        }

        val grid = Array(maxx + 1) { IntArray(maxy + 1) }
        val regions = HashMap<Int, Int>()

        for (x in 0..maxx) {
            for (y in 0..maxy) {

                var best = maxx + maxy
                var bestnum = -1

                // find distance to closest point
                for ((i, p) in points.withIndex()) {


                    val dist = Math.abs(x - p.x) + Math.abs(y - p.y)
                    if (dist < best) {
                        best = dist
                        bestnum = i
                    } else if (dist == best) {
                        bestnum = -1
                    }
                }

                grid[x][y] = bestnum
                var total: Int? = regions[bestnum]
                total = if (total == null) {
                    1
                } else {
                    total.toInt() + 1
                }
                regions[bestnum] = total
            }
        }

        // remove infinite, borrowed starts here
        for (x in 0..maxx) {
            var bad = grid[x][0]
            regions.remove(bad)
            bad = grid[x][maxy]
            regions.remove(bad)
        }
        for (y in 0..maxy) {
            var bad = grid[0][y]
            regions.remove(bad)
            bad = grid[maxx][y]
            regions.remove(bad)
        }
        // borrowed ends here

        var biggest = 0
        for (size in regions.values) {
            if (size > biggest) {
                biggest = size
            }
        }
        return "$biggest"
    }

    override fun part2(): String {
        var inarea = 0

        for (x in 0..maxx) {
            for (y in 0..maxy) {

                var size = 0
                for (p in points) {
                    val dist = Math.abs(x - p.x) + Math.abs(y - p.y)
                    size += dist
                }

                if (size < 10000) {
                    inarea++
                }

            }
        }
        return "$inarea"
    }


    data class Point(val x: Int, val y: Int) {
        constructor(str: String) : this(
            str.split(", ").map { it.toInt() }.first(),
            str.split(", ").map { it.toInt() }.last()
        )
    }


}