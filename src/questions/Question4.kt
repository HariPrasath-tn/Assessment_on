package questions
/*
 * program to find whether the given two arrays are equal in both elements and size
 */
class Question4 {
    /**
     * method to find whether the given arrays are equal or not
     * i.e: arrays are equal if it contains same elements
     *
     * @param arr1 array of integers
     * @param arr2 array of integers
     *
     * @return boolean if(arrays are equal)
     *
     */
    fun isEqual(arr1:Array<Int>, arr2:Array<Int>):Boolean{
        var arrayList:ArrayList<Int> = arrayListOf<Int>(*arr2);

        // iterating through the array
        for(element in arr1){
            // removing the element from the array list if it contains it
            if(arrayList.contains(element)){
                arrayList.remove(element)
                continue
            }
            return false
        }
        return true
    }
}

fun main(){
    print(Question4().isEqual(arrayOf(1, 2, 0, 4, 0), arrayOf(2, 4, 0, 0, 1)))
}