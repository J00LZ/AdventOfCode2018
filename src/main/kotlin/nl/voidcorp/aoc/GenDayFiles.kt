package nl.voidcorp.aoc

import java.util.*
import java.util.concurrent.TimeUnit

@Suppress("UNCHECKED_CAST")
fun main(args: Array<String>) {

    val date = GregorianCalendar(Locale.forLanguageTag("NL-nl"))[GregorianCalendar.DAY_OF_MONTH]
    val b = Class.forName("nl.voidcorp.aoc.Day$date") as Class<DayBase>
    val c = b.getConstructor().newInstance()
    val t = System.nanoTime()
    c.run(getText(date))
    val q = System.nanoTime()-t
    println("ran in ${TimeUnit.MILLISECONDS.convert(q,TimeUnit.NANOSECONDS)}")

}

