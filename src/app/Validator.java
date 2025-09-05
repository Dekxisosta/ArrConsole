package app;

/**
 * Validates incoming input from the console. Also equipped with low-level parsers
 * <p><b>DEPENDENCIES:</b></p>
 * <ul>
 *     <li>{@link Input}</li>
 *     <li>{@link CustomException}</li>
 * </ul>
 */
class Validator{
    /*===============================
     * VALID GETTER METHOD
     *===============================*/
    /**
     * Gets a valid integer
     * @return valid integer
     */
    static int getInt(){
        while(true){
            try{
                return parseInt(Input.readLine());
            }catch(IllegalArgumentException e){
                UI.showMessage(ConsoleTag.ERROR, e.getMessage());
                UI.showEnterPrompt();
            }
        }
    }
    /**
     * Gets a valid integer within the range of min max
     * @param min the minimum value to be inputted, inclusive
     * @param max the maximum value to be inputted, inclusive
     * @return valid integer within min max
     */
    static int getInt(int min, int max){
        int value;
        while(true){
            value = getInt();
            if(value >=min && value <= max){
                return value;
            }
            UI.showMessage(ConsoleTag.ERROR, "Must be within " + min + " - " + max + ". ");
        }
    }

    /**
     * Gets a valid boolean value
     * @return valid boolean input
     */
    static boolean getBoolean(){
        while(true){
            try{
                return parseBoolean(Input.readLine());
            }catch(IllegalArgumentException e){
                UI.showMessage(ConsoleTag.ERROR, e.getMessage());
                UI.showEnterPrompt();
            }
        }
    }
    /*===============================
     * PARSER METHODS
     *===============================*/
    /** Parses an integer */
    static int parseInt(String input) throws IllegalArgumentException{
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw CustomException.unableToParseInt();
        }
    }
    /** Parses a boolean based on String input */
    static Boolean parseBoolean(String input) throws IllegalArgumentException{
        if("0".equals(input) || "no".equalsIgnoreCase(input) || "n".equalsIgnoreCase(input)) return false;
        if("1".equals(input) || "yes".equalsIgnoreCase(input) || "y".equalsIgnoreCase(input)) return true;
        throw CustomException.unableToParseBoolean();
    }
}