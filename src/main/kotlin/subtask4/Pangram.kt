package subtask4

class Pangram {


    fun getResult(inputString: String): String {
        // throw NotImplementedError("Not implemented")
        val alphabet = 'a'..'z'
        val alphabetUp = 'A'..'Z'
        val vowels = arrayOf('a', 'e', 'i', 'o', 'u', 'y')
        val vowelsUp = arrayOf('A', 'E', 'I', 'O', 'U', 'Y')
        var result = ""
        var count = 0

        for (i in alphabet) {
            if (inputString.contains(i.toLowerCase()) || inputString.contains(i.toUpperCase()))
                ++count
        }

        val splittedArr = inputString.split("\\s+".toRegex())

        var resultList = mutableListOf<String>()


        if (count >= 26) {
            //pangram
            var countOfVow = 0
            var ourWord = ""
            for (word in splittedArr) {
                for (symbol in word.toCharArray()) {
                    if (vowels.contains(symbol)) {
                        ++countOfVow
                        ourWord = ourWord + symbol.toUpperCase()
                    } else {
                        ourWord = ourWord + symbol
                    }
                }
                resultList.add("$countOfVow$ourWord")
                ourWord = ""
                countOfVow = 0
            }


            do {
                var swapped = false
                for (index in 1 until resultList.size) {
                    val previousItem = resultList[index - 1]
                    val currentItem = resultList[index]
                    if (previousItem.get(0).toInt() > currentItem.get(0).toInt()) {
                        resultList.set((index - 1), currentItem)
                        resultList.set((index), previousItem)
                        swapped = true
                    }
                }
            } while (swapped)


            for (fd in resultList) {
                result = result + " $fd"
            }

            result = result.trim()

        } else {
            //not pangram
            var countOfCon = 0
            var ourWord = ""
            for (word in splittedArr) {
                for (symbol in word.toCharArray()) {
                    if (!vowels.contains(symbol) && !vowelsUp.contains(symbol) && (alphabet.contains(
                            symbol
                        ) || alphabetUp.contains(symbol))
                    ) {
                        ++countOfCon
                        ourWord = ourWord + symbol.toUpperCase()
                    } else {
                        ourWord = ourWord + symbol
                    }
                }
                resultList.add("$countOfCon$ourWord")



                ourWord = ""
                countOfCon = 0
            }

            do {
                var swapped = false
                for (index in 1 until resultList.size) {
                    val previousItem = resultList[index - 1]
                    val currentItem = resultList[index]
                    if (previousItem.get(0).toInt() > currentItem.get(0).toInt()) {
                        resultList.set((index - 1), currentItem)
                        resultList.set((index), previousItem)
                        swapped = true
                    }
                }
            } while (swapped)


            for (fd in resultList) {
                if (fd != "0") {
                    result = result + " $fd"
                }

            }

            if (!result.isEmpty()) {
                result = result.trim()
            }

        }


        try {
            if (result.substring(0, 2) == "0 ") {
                return result.substring(2, result.length)
            } else {
                return result
            }
        } catch (ex: Exception) {

        }

        return result
    }
}
