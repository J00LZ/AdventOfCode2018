package nl.voidcorp.aoc

class Day3 : DayBase(3) {

    val arr = MutableList(1000) { MutableList(1000) { 0 } }
    val items = list.map { Item.new(it) }
    override fun part1(): String {

        for (item in items) {

            for (x in item.x until item.coords.first+item.x) {
                for (y in item.y until item.coords.second+item.y) {
                    arr[y][x] += 1
                    //println("$x,$y=${arr[y][x]}")
                }
            }
        }

        var count = 0

        for (r in arr){
            for (c in r){
                if (c>1){
                    count++
                }
            }
        }

        return count.toString()
    }

    override fun part2(): String {

        for (item in items) {
            var isbig=0
            for (x in item.x until item.coords.first+item.x) {
                for (y in item.y until item.coords.second+item.y) {
                    if(arr[y][x]>1){
                        isbig++
                    }
                    //println("$x,$y=${arr[y][x]}")
                }
            }
            if (isbig==0){
                return item.id.toString()
            }
        }

        return ""
    }

    data class Item(val id: Int, val x: Int, val y: Int, val coords: Pair<Int, Int>) {
        companion object {
            fun new(string: String): Item {
                val key = string.split("@").map { it.trim() }
                val m = key.last().trim().split(':').map { it.trim() }

                return Item(
                    key.first().trim().substring(1).toInt(),
                    m.first().split(",").first().toInt(), m.first().split(",").last().toInt(),
                    m.last().split("x").map { it.toInt() }.let { it.first() to it.last() })
            }
        }
    }
}