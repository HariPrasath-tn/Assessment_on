package questions;

import java.util.ArrayList;
import java.util.Arrays;

import static input.Input.jInput;
import static input.Input.jInt;
import static java.lang.System.out;
import static java.lang.System.setIn;

/*
 * program to find the largest subArray whose sum is zero
 */
public class Question3 {
    ArrayList<ArrayList<Integer>> collection = new ArrayList<>();
    ArrayList<Integer> MaxList;
    int maxSize = 0;
    /**
     * method to find all the possible sub arrays
     * @param array integer array
     *
     * Methodology :
     *              iterate through array for all possible elements
     */
    private void formAllPossibleSubArrays(int[] array){
        int count=0;
        ArrayList<Integer> mainL = new ArrayList<>();
        for(int startingElementPosition=0; startingElementPosition<array.length; startingElementPosition++){
            for(int subElementPosition=0; subElementPosition<array.length; subElementPosition++){
                count=subElementPosition;
                ArrayList<Integer> temp = new ArrayList<>();
                for(int position=0; position<count+2 && position<array.length; position++){
                    if(position!=startingElementPosition)
                        temp.add(array[position]);
                }
                count++;
                if(temp.size()>1)
                    collection.add(temp);
            }
            mainL.add(array[startingElementPosition]);
        }
        collection.add(mainL);
    }

    /**
     * method to find whether the given arraylist's sum is zero or not
     * @param arrayList ArrayList<Integer>
     * @return boolean(true if sum == 0)
     *
     * Methodology:
     *      sum all the elements in the arraylist
     *      if(sum == 0)
     *          return true
     *      else return false
     */
    private boolean isSumZero(ArrayList<Integer> arrayList){
        int sum=0;
        for(int element: arrayList){
            sum += element;
        }
        if(sum == 0)
            return true;
        return false;
    }

    /**
     * method to find the largest array with sum zero
     * @return string of the resultant MaxList with sum zero
     *
     * Methodology:
     *      MaxList = empty ArrayList()
     *      parse through the collection(ArrayList) containing all the possible sub arrays
     *      if the array's sum ==0 and greater than MaxList size:
     *          MaxList = array
     */
    private String findLargestArrayWithSumZero(){
        for(ArrayList<Integer> arrayList: collection){
            if(isSumZero(arrayList) && arrayList.size()>maxSize){
                MaxList = arrayList;
                maxSize = arrayList.size();
            }
        }

        // converting the arrayList to string as the required type is String
        String result = MaxList.toString();
        // if there is no array with sum zero returns nill else returns the array
        return result.length() > 2 ?result.substring(1,result.length()-1) : "nill";
    }


    public static void main(String[] args) throws Exception {
        int sizeOfArray = jInt(jInput("Enter the size of the array : "));
        int [] array = new int[sizeOfArray];
        String [] arrayElement = jInput("Enter the elements fo the array in space Separated format : ").split(" ");
        for(int elementAt=0; elementAt<sizeOfArray; elementAt++){
            array[elementAt] = jInt(arrayElement[elementAt]);
        }

        Question3 question3 = new Question3();
        question3.formAllPossibleSubArrays(array);
        out.println(question3.findLargestArrayWithSumZero());
    }
}
