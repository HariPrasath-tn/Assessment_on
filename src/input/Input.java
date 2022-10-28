package input;
/*
 * Program to get user input with basic System input method inorder to minimize the memory usage
 */

import java.io.IOException;
import static java.lang.System.out;

public class Input {

    /**
     * method to get String input
     *
     * @param request
     * @return String response (from console)
     *
     * @Methodology:
     *      initializing input = empty string
     *      initializing letter = space character
     *      @while iteration:  till pressing enter button
     *          reading sing character from user
     *          appending character to String variable "input"
     *
     * finally      ==> returns input
     *
     */
    public static String jInput(String request) throws IOException {
        out.print(request);
        String input = "";
        char letter = ' ';
        // get input until the new line provided
        while( letter != 10){
            letter = (char)System.in.read();
            // validating whether the input character is newLine or not
            // if new prevent it from appending
            if(letter != 10)
                input += letter;
        }
        return input;
    }

    /**
     * method to get integer input
     *
     * @param number
     * @return integer response (from console)
     *
     * @Methodology:
     *      getString input from user using method [jInt]
     *      parses it into Number
     *
     *
     * finally      ==> returns integer input
     *
     */
    public static int jInt(String number) throws Exception {
        int input = 0;

        /*
         * validating for the number
         * if not number ==> throws ValueErrorException
         */
        try{
            input = Integer.parseInt(number);
        }catch(Exception e){
            throw new ValueErrorException("Invalid literal for int() with base 10: 'a'");
        }
        return input;
    }

    /**
     * ValueErrorException is a class used to raise Exception when irrelevant type of input is given
     *
     * extends Exception
     */
    public static class ValueErrorException extends Exception{
        /**
         * Constructor
         * @param message
         *
         * passes message to the super class
         */
        ValueErrorException(String message ){
            super(message);
        }
    }

}
