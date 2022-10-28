package questions;

import java.util.ArrayList;

import static input.Input.jInput;
import static input.Input.jInt;
import static java.lang.System.out;

/*
 * program to solve the question 1
 *
 * Q : To find the number of substring in the string that can be an anagram
 */
public class Question1 {
    private ArrayList<String> possiblePatterns = new ArrayList<String>();

    /**
     * method to find all possible patterns
     * @param string of type String
     *
     * Methodology:
     *       iterate through the given string
     *       find all possible pattens
     *       store it in the arrayList
     */
    private void findPossiblePatterns(String string){
        int stringLength = string.length();
        for(int startingCharacter=0; startingCharacter<stringLength; startingCharacter++){
            String temp = "";
            for(int charAt_=startingCharacter; charAt_<stringLength; charAt_++){
                // character at the charAt_ in given string
                temp += string.charAt(charAt_);
                possiblePatterns.add(temp);
            }
        }
    }

    /**
     * Method to find the given strings are anagram or not
     * @param string1 of type String (subString of the given String)
     * @param string2 of type String (subString of the given String)
     * @return boolean value
     *
     * Methodology:
     *      converting string2 to arrayList
     *      parsing through the string1 characters
     *      if character available in the arraylist:
     *          remove it and continue
     *      return false
     */
    private boolean isAnagram(String string1, String string2){
        // if the string1 length is not same as the string 2 return false
        if(string1.length() != string2.length())
            return false;

        /*
         * initializing the arrayList after the control flow as there is no need
         * for arrayList if the length is not same which may result in waste of memory
         */
        ArrayList<Character> string2ArrayList = new ArrayList<>();

        // forming the character arraylist
        for(int position=0; position<string2.length(); position++){
            string2ArrayList.add(string2.charAt(position));
        }

        // validating whether each character in the given string1 is available in string2 or not
        for(char letter: string1.toCharArray()){
            if(string2ArrayList.contains(letter)){
                string2ArrayList.remove(string2ArrayList.indexOf(letter));
                continue;
            }
            return false;
        }
        return true;
    }

    /**
     * method to find the number of possible anagrams
     *
     * Methodology:
     *      parsing through the all possible patterns
     *      if any pair matches the anagram :
     *          increase the count
     *
     * @return count (possible anagram count)
     */
    private int possibleAnagrams(){
        int count = 0;
        for(int string1Pos=0; string1Pos<possiblePatterns.size(); string1Pos++){
            for(int string2Pos=string1Pos+1;string2Pos<possiblePatterns.size(); string2Pos++){
                if(isAnagram(possiblePatterns.get(string1Pos), possiblePatterns.get(string2Pos))) {
                    count++;
                }
            }
        }
        possiblePatterns.clear();
        return count;
    }

    public static void main(String [] args) throws Exception{
        int testCases = jInt(jInput("Enter the test case count : "));
        String result = "";
        for(int testcase=0; testcase<testCases; testcase++){
            String string = jInput("Enter the String : ");
            Question1 question1 = new Question1();
            question1.findPossiblePatterns(string);
            result += question1.possibleAnagrams() + "\n";
        }
        out.println(result);
    }

}
