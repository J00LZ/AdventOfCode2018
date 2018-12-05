package nl.voidcorp.aoc


fun main(args: Array<String>) {
    val map = listOf(Day1, Day2, Day3, Day4, Day5)
    /*val date = GregorianCalendar(Locale.forLanguageTag("NL-nl"))[GregorianCalendar.DAY_OF_MONTH]
    val b = Class.forName("nl.voidcorp.aoc.Day$date") as Class<DayBase>
    val c = b.getConstructor().newInstance()
    c.run(getText(date))*/
    var total = 0L
    for (d in map) {
        total += d.run()
    }
    println("Total time ran for days 1-${map.size}: $total")

}

