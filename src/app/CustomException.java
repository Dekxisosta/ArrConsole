package app;

/**
 * A class that uses {@link IllegalArgumentException} to handle
 * expected and a few unexpected errors in the system
 */
class CustomException{
    /*===============================
     * PROGRAM EXCEPTIONS
     *===============================*/
    /** Throws an exception when unable to parse an integer value */
    static IllegalArgumentException unableToParseInt(){
        return new IllegalArgumentException("Unable to parse integer. Try again");
    }

    /** Throws an exception when unable to parse a string value */
    static IllegalArgumentException unableToParseString(){
        return new IllegalArgumentException("Unable to parse string. Try again");
    }

    /** Throws an exception when unable to parse a boolean value */
    static IllegalArgumentException unableToParseBoolean(){
        return new IllegalArgumentException("Unable to parse boolean. Try again");
    }
}
