package subtask1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {


    fun toTextDay(day: String, month: String, year: String): String {
        //throw NotImplementedError("Not implemented")

        val months = arrayOf(
            "января", "февраля", "марта", "апреля", "мая", "июня",
            "июля", "августа", "сентября", "октября", "ноября", "декабря"
        )
        val weekday =
            arrayOf(
                "понедельник",
                "вторник",
                "среда",
                "четверг",
                "пятница",
                "суббота",
                "воскресенье"
            )

        var result = "Такого дня не существует"
        try {

            var date = LocalDate.parse(
                "${year}-${if (month.length == 1) {
                    "0$month"
                } else {
                    month
                }}-${if (day.length == 1) {
                    "0$day"
                } else {
                    day
                }}"
            )

            result =
                "${date.dayOfMonth} ${months[date.month.value - 1]}, ${weekday[date.dayOfWeek.value - 1]}"
        } catch (ex: Exception) {
            return result
        }
        return result
    }
}
