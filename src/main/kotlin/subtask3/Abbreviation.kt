package subtask3

class Abbreviation {


    fun abbreviationFromA(a: String, b: String): String {
        //throw NotImplementedError("Not implemented")
        var result = "NO"
        var ourString = ""
        for (indexA in 0..a.length -1){
            for (indexB in 0..b.length -1){
                if (a.toUpperCase().get(indexA) == b.get(indexB)){
                    ourString = "${ourString}${a.toUpperCase().get(indexA)}"
                }
            }
        }

        if (ourString == b){
            result = "YES"
        }

        return result
    }
}
