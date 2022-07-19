import kotlin.random.Random

enum class cases_ru {
    IMENITELNIY, RODITELNIY, DATELNIY, VINITELNIY, TVORITELNIY, PREDLOZHNIY
}

fun main() {
    val sec:Int = Random.nextInt(0, 30*60*60) // чуть больше суток
    //val sec:Int = 11787

    println("$sec сек. :")
    println(agoToText(sec))
}

fun agoToText(sec:Int):String = "был(а) в сети " + when(sec) {
    in 0..60 -> "только что"
    in 61..60*60 -> "${sec/60} ${declination_ru("минут", sec/60, cases_ru.RODITELNIY)} назад"
    in 60*60+1..24*60*60 -> "${sec/60/60} ${declination_ru("час", sec/60/60, cases_ru.RODITELNIY)} назад"
    in 24*60*60+1..2*24*60*60 -> "сегодня"
    in 2*24*60*60+1..3*24*60*60 -> "вчера"
    else -> "давно"
    }

fun declination_ru(wordPart:String, number:Int, case:cases_ru):String {
    var result:String = wordPart /* без специального правила вернем просто начальную форму */

    if (case == cases_ru.RODITELNIY) {
        if (wordPart == "час") {

            result = if (number%100>10 && number%100<20) {
                "часов"
            }
            else {
                when (number % 10) {
                    0 -> "часов"
                    1 -> "час"
                    2, 3, 4 -> "часа"
                    else -> "часов"
                }
            }

        } else if (wordPart == "минут") {

            result = if (number%100>10 && number%100<20) {
                "минут"
            }
            else {
                when (number % 10) {
                    0 -> "минут"
                    1 -> "минуту"
                    2, 3, 4 -> "минуты"
                    else -> "минут"
                }
            }
        }
    }
    else {
        /* для других падежей не будем загоняться */
    }

    return result
}