package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Reads console input using {@link BufferedReader}
 *
 * <p><b>DEPENDENCIES:</b></p>
 * <ul>
 *     <li>{@link BufferedReader} efficient reader for the program's runtime</li>
 *     <li>{@link InputStreamReader} ensures inputs come from console</li>
 *     <li>{@link IOException} handles invalid outputs, changed as an illegal arg exception</li>
 * </ul>
 */
class Input{
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /*===============================
     * CONSOLE READER METHODS
     *===============================*/
    /**
     * Reads a line of input in the console, transforms IOException to an {@link IllegalArgumentException}
     * for invalid inputs like Strings, booleans, etc. are expected
     */
    static String readLine() throws IllegalArgumentException{
        try{
            return reader.readLine();
        }catch(IOException e){
            throw CustomException.unableToParseString();
        }
    }
    /** Closes the reader to save resources, more of a safety net for when the JVM does not close it*/
    static void close(){
        try{
            reader.close();
        }catch(IOException ignored){}
    }
}