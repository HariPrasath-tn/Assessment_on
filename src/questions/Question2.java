package questions;

import java.util.Arrays;

import static input.Input.jInput;
import static input.Input.jInt;
import static java.lang.System.out;

/**
 * program to find the leader in the given array
 * i : element of an array is said to be leader if it is grater than all the elements right to it
 * and the last element in the last position is always a leader since no next element on right side
 */
public class Question2 {
    /**
     * method to find whether the element at the given position is greater than all the elements
     * in right side of it
     * @param position integer (position of the element)
     * @return boolean if (greater than all the right elements)
     */
    private boolean isLeader(int position, int [] array){
        for(int current=position+1; current<array.length; current++){
            if(array[position] < array[current]){
                return false;
            }
        }
        return true;
    }


    /**
     * method to find the leader in the given array
     *  * i : element of an array is said to be leader if it is grater than all the elements right to it
     *  * and the last element in the last position is always a leader since no next element on right side
     *
     * @param array integer array
     * @return String of all leaders
     */
    private String findAllLeaders(int[] array){
        String leaders = "";
        for(int position=0; position<array.length; position++){
            if(isLeader(position, array)){
                leaders += array[position] + " ";
            }
        }

        return leaders;
    }

    public static void main(String [] args) throws Exception{
        int sizeOfArray = jInt(jInput("Enter the size of the array : "));
        int [] array = new int[sizeOfArray];
        String [] arrayElement = jInput("Enter the elements fo the array in space Separated format : ").split(" ");
        for(int elementAt=0; elementAt<sizeOfArray; elementAt++){
            array[elementAt] = jInt(arrayElement[elementAt]);
        }
        out.println(new Question2().findAllLeaders(array));
    }
}
