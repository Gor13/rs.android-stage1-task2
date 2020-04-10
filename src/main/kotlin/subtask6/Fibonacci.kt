package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(n: Int): IntArray {
        // throw NotImplementedError("Not implemented")
        var fnNull = 0
        var fnPlusOne = 1
        while (true) {
            if (fnNull * fnPlusOne == n) {
                return mutableListOf<Int>(fnNull, fnPlusOne, 1).toIntArray()
            } else if (fnNull * fnPlusOne > n) {
                return mutableListOf<Int>(fnNull, fnPlusOne, 0).toIntArray()
            } else {
                val s = fnPlusOne
                fnPlusOne = fnPlusOne + fnNull
                fnNull = s
            }
        }
    }
}
