package subtask2

import java.lang.Exception

class TimeConverter {


    fun toTextFormat(hour: String, minute: String): String {

       // throw NotImplementedError("Not implemented")
        val nums = arrayOf(
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one",
            "twenty two", "twenty three", "twenty four",
            "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine"
        )

        val h = hour.toInt()
        val m = minute.toInt()
        var result = ""

        try {
            if (m === 0) result = (nums[h] + " o' clock") else if (m === 1) result = (
                    "one minute past " +
                            nums[h]
                    ) else if (m === 59) result = (
                    "one minute to " +
                            nums[h % 12 + 1]
                    ) else if (m === 15) result = ("quarter past " + nums[h]) else if (m === 30) result = (
                    "half past " + nums[h]
                    ) else if (m === 45) result = (
                    "quarter to " +
                            nums[h % 12 + 1]
                    ) else if (m <= 30) result = (
                    nums[m] + " minutes past " +
                            nums[h]
                    ) else if (m > 30) result = (
                    nums[60 - m] + " minutes to " +
                            nums[h % 12 + 1]
                    )

        } catch (ex : Exception) {

        }


        return result
    }

}
