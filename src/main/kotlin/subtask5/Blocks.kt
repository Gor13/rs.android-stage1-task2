package subtask5

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass



class Blocks {


    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        //  throw NotImplementedError("Not implemented")
        var resultStr = ""
        var resultInt = 0
        var resultDate = ""
        var resultLong: Long = 0

        if ((blockB.java).toString() == "class java.lang.String"){
            for (element in blockA){
                if (element is String){
                    resultStr = resultStr + element
                }
            }
            return resultStr
        }

        if ((blockB.java).toString() == "int"){
            for (element in blockA){
                if (element is Int){
                    resultInt += element
                }
            }
            return resultInt
        }

        if ((blockB.java).toString() == "class java.time.LocalDate"){
            for (element in blockA){
                if (element is LocalDate){
                    if (resultLong < SimpleDateFormat("yyyy-MM-dd").parse(element.toString()).time){
                        resultLong = SimpleDateFormat("yyyy-MM-dd").parse(element.toString()).time
                        resultDate = element.format( DateTimeFormatter.ofPattern("dd.MM.yyyy"))

                    }
                }
            }
            return resultDate
        }

        return Any()
    }
}
