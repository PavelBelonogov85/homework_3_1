import kotlin.random.Random

enum class cases_ru {
    IMENITELNIY, RODITELNIY, DATELNIY, VINITELNIY, TVORITELNIY, PREDLOZHNIY
}

fun main() {
    val sec:Int = Random.nextInt(0, 30*60*60) // ���� ������ �����
    //val sec:Int = 11787

    println("$sec ���. :")
    println(agoToText(sec))
}

fun agoToText(sec:Int):String = "���(�) � ���� " + when(sec) {
    in 0..60 -> "������ ���"
    in 61..60*60 -> "${sec/60} ${declination_ru("�����", sec/60, cases_ru.RODITELNIY)} �����"
    in 60*60+1..24*60*60 -> "${sec/60/60} ${declination_ru("���", sec/60/60, cases_ru.RODITELNIY)} �����"
    in 24*60*60+1..2*24*60*60 -> "�������"
    in 2*24*60*60+1..3*24*60*60 -> "�����"
    else -> "�����"
    }

fun declination_ru(wordPart:String, number:Int, case:cases_ru):String {
    var result:String = wordPart /* ��� ������������ ������� ������ ������ ��������� ����� */

    if (case == cases_ru.RODITELNIY) {
        if (wordPart == "���") {

            result = if (number%100>10 && number%100<20) {
                "�����"
            }
            else {
                when (number % 10) {
                    0 -> "�����"
                    1 -> "���"
                    2, 3, 4 -> "����"
                    else -> "�����"
                }
            }

        } else if (wordPart == "�����") {

            result = if (number%100>10 && number%100<20) {
                "�����"
            }
            else {
                when (number % 10) {
                    0 -> "�����"
                    1 -> "������"
                    2, 3, 4 -> "������"
                    else -> "�����"
                }
            }
        }
    }
    else {
        /* ��� ������ ������� �� ����� ���������� */
    }

    return result
}