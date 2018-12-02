package nl.voidcorp.aoc

import java.util.*

@Suppress("UNCHECKED_CAST")
fun main(args: Array<String>) {

    val date = GregorianCalendar(Locale.forLanguageTag("NL-nl"))[GregorianCalendar.DAY_OF_MONTH]
    val b = Class.forName("nl.voidcorp.aoc.Day$date") as Class<DayBase>
    val c = b.getConstructor().newInstance()
    c.run(getText(date))
}

