package questions

/*
 * program to find the first element that occurs at least k times
 */
class Question5 {
    var dictionary:HashMap<Int, Int> = HashMap()

    /**
     * method to find the first element that occurs at least k times
     */
    fun findElementOccursKTimes(array:Array<Int>, K:Int):Int{
        for(ele in array){
            // adding count for the element if already exists
            if(dictionary.containsKey(ele)){
                dictionary[ele] = dictionary[ele]!! + 1
                if(dictionary[ele]!! >= K)
                    return ele
                continue
            }
            // if not available in the hash map append it
            dictionary[ele] = 1

        }
        // exception thrown when there is no element that occurs at least K times
        throw NoElementFoundException("No Element that occurs K times")
    }
}

fun main(){
    print(Question5().findElementOccursKTimes(arrayOf(1, 7, 4, 3, 4, 8, 7), 2))
}


/**
 * [NoElementFoundException] Exception thrown when no elements in the given array occurs at least for k times
 */
class NoElementFoundException(message:String):Exception(message)