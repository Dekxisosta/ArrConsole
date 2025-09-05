package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Runs the program. The orchestrator of all classes
 * in the Main file
 */
public class Main {
    /** Determines program continuation */
    static boolean isContinueProgram = true;

    /**
     * Container for action names, used when displaying options, and
     * determining switch-case statement length
     */
    static String[] actionNames = {
        "Terminate Program", // must be on top for value 0 in actionMenu showOptions
        "Set Array Size and Numbers",
        "View Numbers",
        "Show Count of Occurrences of an Element",
        "Show Indices of All Occurrences of an Element",
        "Show Elements with Duplicates",
        "Show the Most Occurring element in the Array",
        "Show First non-repeating element in the Array"
    };

    /*===============================
     * ENTRY POINT
     *===============================*/

    /**
     * Serves as an entry-point of the program
     * @param args command-line args (not-used)
     */
    public static void main(String[] args) {
        try{
            new Main().run(); // creates an instance of main and runs the private run method
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /*===============================
     * PROGRAM RUNNER
     *===============================*/
    /**
     * Runs the program. Initializes array size and numbers before performing actions from
     * the action menu
     */
    private void run(){
        // Introductory message
        UI.showMessage(ConsoleTag.SYSTEM, "You're now using " + Properties.getProgramName());

        //Initialize array size and numbers, also ensures no null pointer exceptions
        Actions.getArraySize();
        Actions.getNumbers();


        while(isContinueProgram){
            //Shows banner and menu
            UI.showBanner(Properties.getProgramName());
            UI.showMenu(actionNames);

            //Shows enter prompt
            UI.showEnterPrompt("your choice");

            //Performs an action based on user input
            performActionFromMenu(Validator.getInt(0, actionNames.length));
        }
        Input.close();
    }
    /*===============================
     * ACTION MENU
     *===============================*/
    /**
     * Mapped actions in a switch-case statement.
     * Tightly-coupled with the {@link Actions} for
     * performance of program actions/operations
     *
     * @param choice the user's wanted action
     * @see Actions
     */
    private void performActionFromMenu(int choice){
        switch(choice){
            //Sets array size and numbers
            case 1:
                Actions.getArraySize();
                Actions.getNumbers();
                break;
            //Views numbers of the current array
            case 2:
                Actions.viewNumbers();
                break;
            //Views the count of the number of occurrences of an element
            case 3:
                UI.showMessage(ConsoleTag.SYSTEM, "Performing view count of occurrences...");
                Actions.showNumberOfOccurrencesOfAnElement();
                break;
            //Views the indices of all occurrences of an element
            case 4:
                UI.showMessage(ConsoleTag.SYSTEM, "Performing indices of occurrences...");
                Actions.showIndicesOfAllOccurrencesOfAnElement();
                break;
            //Views the elements in the array that has duplicates
            case 5:
                UI.showMessage(ConsoleTag.SYSTEM, "Performing elements with duplicates...");
                Actions.showElementsWithDuplicates();
                break;
            //Views the most occurring element in the array
            case 6:
                UI.showMessage(ConsoleTag.SYSTEM, "Performing element with the most occurrences...");
                Actions.showMostOccurringElement();
                break;
            //Views the first non-repeating element in the array
            case 7:
                UI.showMessage(ConsoleTag.SYSTEM, "Performing first non-repeating element...");
                Actions.showFirstNonRepeatingElement();
                break;
            case 0:
                Actions.setContinueProgram();
                break;
        }
    }
}
/**
 * Actions that are used within the program. Tightly-coupled with Main class
 * @see Main
 */
class Actions{
    /** Gets a target element and shows count/number of occurrences */
    static void showNumberOfOccurrencesOfAnElement(){
        UI.showMessage(ConsoleTag.SYSTEM, "Input the integer/element to count");
        UI.showEnterPrompt("element");
        int countElement = Validator.getInt();
        int counter = 0;

        // for every element, check if value is equal to user input value
        for (int i = 0 ; i < Data.arraySize; i++)
            if (countElement == Data.numbers[i])
                counter++;
        UI.printf("The element %d occurs %d time/s in the array", countElement, counter);
    }



    /** Gets a target element and shows indices of all occurrences of it*/
    static void showIndicesOfAllOccurrencesOfAnElement() {
        // Get the value to search
        UI.showMessage(ConsoleTag.SYSTEM, "Input the integer/element to show indices");
        UI.showEnterPrompt("element");
        int element = Validator.getInt();

        UI.showMessage(ConsoleTag.INFO, "Occurrences of element " + element + ": ");

        boolean found = false;
        boolean isFirst = true;

        for (int i = 0; i < Data.numbers.length; i++) {
            if (Data.numbers[i] == element) {
                if (!isFirst) {
                    UI.printf(", ");
                }
                UI.printf("%d", i);
                isFirst = false;
                found = true;
            }
        }

        if (!found) {
            UI.printf("None");
        }

        UI.println();
    }



    /** Shows elements with duplicates */
    static void showElementsWithDuplicates(){
        UI.printf("%nDuplicate elements in the array are: ");

        boolean isFirst = true;// controls comma formatting

        // Check if the element has already been printed before
        for (int i = 0; i < Data.arraySize; i++) {
            boolean isPrinted = false;

            for (int k = 0; k < i; k++) {
                if (Data.numbers[i] == Data.numbers[k]) {
                    isPrinted = true;
                    break;
                }
            }

            if (isPrinted)
                continue;

            // Compare with next elements
            for (int j = i + 1; j < Data.numbers.length; j++) {
                if (Data.numbers[i] == Data.numbers[j]) {
                    if (!isFirst) {
                        UI.printf(", ");
                    }
                    UI.printf(String.valueOf(Data.numbers[i]));
                    isFirst = false;
                    break; // break ensures when printed once
                }
            }
        }
        UI.println();
    }



    /** Shows the most occurring element in the array */
    static void showMostOccurringElement(){
        int currentOccurrences; // current element's counter for duplicates
        int mostOccurrences = 0; // counter of the current most occurring element
        int indexOfMostOccurred = 0; // the index of the element that has the most occurrences

        for (int i = 0; i < Data.numbers.length - 1; i++) {
            currentOccurrences = 1;

            for (int j = i + 1; j < Data.numbers.length; j++) {
                //checks if element is equal
                if (Data.numbers[i] == Data.numbers[j]) {
                    currentOccurrences++;
                }
                //checks if greater than current most occurrences
                if(currentOccurrences > mostOccurrences){
                    mostOccurrences = currentOccurrences;
                    indexOfMostOccurred = i;
                }
            }
        }
        UI.printf("%nMost occurring element: %d (occurs %d times)", Data.numbers[indexOfMostOccurred], mostOccurrences);
    }



    /** Shows the first non-repeating element in the array */
    static void showFirstNonRepeatingElement(){
        boolean isNonRepeating = false; //initialized as false for possible no non-repeating elements in the array

        for(int i=0; i < Data.numbers.length; i++){
            isNonRepeating = true; // set to true for program loop
            for(int j=0; j < Data.numbers.length; j++){
                if(Data.numbers[i] == Data.numbers[j] && i!=j){// if repeating, then set to false
                    isNonRepeating = false;
                    break;
                }
            }
            if(isNonRepeating){
                UI.printf("%nThe first non-repeating element is: %s ", Data.numbers[i]);
                break;
            }
        }

        if(!isNonRepeating)
            UI.printf("%nThere are no non-repeating elements in the array");
    }

    /** Gets the array size for program runtime */
    static void getArraySize(){
        UI.showMessage(ConsoleTag.SYSTEM, "Input array size");
        UI.showEnterPrompt("size");
        Data.arraySize = Validator.getInt(0, Data.MAX_ARRAY_SIZE);
        Data.numbers = new int[Data.arraySize];
    }
    /** Gets the numbers for the array */
    static void getNumbers(){
        UI.showMessage(ConsoleTag.SYSTEM, "Input numbers");
        for(int i=0; i<Data.arraySize; i++){
            UI.showEnterPrompt("value for index " + i + ": ");
            Data.numbers[i] = Validator.getInt();
        }
    }
    static void viewNumbers(){
        UI.showMessage(ConsoleTag.INFO, "Showing values of numbers array");
        for(int i=0; i<Data.arraySize; i++){
            UI.printf("%nIndex %s: %s", i, Data.numbers[i]);
        }
    }
    /** Set continue program based on boolean input */
    static void setContinueProgram(){
        UI.showMessage(ConsoleTag.SYSTEM, "Quit Program? (y/n) ");
        Main.isContinueProgram = !Validator.getBoolean();
        if(!Main.isContinueProgram)
            UI.showMessage(ConsoleTag.SYSTEM, "Thank you for using the program!");
    }
}

/**
 * Centralized data class for the array.
 * No accessor functions added due to time constraints
 */
class Data{
    /** The maximum capacity the array can have */
    static int MAX_ARRAY_SIZE = 20;

    /** The size of the array */
    static int arraySize = 0;

    /** The datastore for all integer inputs */
    static int[] numbers;
}
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
    static int parseInt(String input) throws IllegalArgumentException{
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw CustomException.unableToParseInt();
        }
    }
    static Boolean parseBoolean(String input) throws IllegalArgumentException{
        if("0".equals(input) || "no".equalsIgnoreCase(input) || "n".equalsIgnoreCase(input)) return false;
        if("1".equals(input) || "yes".equalsIgnoreCase(input) || "y".equalsIgnoreCase(input)) return true;
        throw CustomException.unableToParseBoolean();
    }
}

/**
 * Properties of the system like program name, etc.
 */
class Properties{
    /** Program name for value */
    private static final String PROGRAM_NAME = "Array Manipulation Program";

    /** Gets program name */
    static String getProgramName(){ return PROGRAM_NAME;}
}

/**
 * Renders visual output in the console
 */
class UI{
    /*===============================
     * CONSOLE RENDERING METHODS
     *===============================*/
    static void showBanner(String title){
        println();
        printBorder(title.length() + 6);
        printf("%n{| %s |}", title);
        printBorder(title.length() + 6);
        println();
    }
    /**
     * Prints a border according to length
     * @param length border length
     */
    static void printBorder(int length){
        printf("%n%s", "=".repeat(length));
    }

    /** Shows a menu of options based on Actions */
    static void showMenu(String[] options){
        for(int i=1; i < options.length; i++){
            printRow(i, options[i]);
        }
        printRow(0, options[0]);
    }

    /** Prints a row with a corresponding number label */
    static void printRow(int order, String label){
        printf("%n[%s] %s", order, label);
    }
    /*===============================
     * PRINT UTILITY METHODS
     *===============================*/
    /** Shows an enter prompt */
    static void showEnterPrompt(){
        showEnterPrompt("");
    }

    /**
     * Shows an enter prompt with the value type to be inputted
     * @param valNameToInput the value type of the prompted input
     */
    static void showEnterPrompt(String valNameToInput){
        printf("%nEnter %s: ", valNameToInput);
    }

    /**
     * Shows messages with label
     * @see ConsoleTag
     */
    static void showMessage(ConsoleTag tag, String message){
        printf("%n%s %s", tag.label(),message );
    }

    /** Shortened line spacer */
    static void println(){System.out.println();}

    /** Shortened conventional printf method */
    static void printf(String format, Object... args){
        System.out.printf(format, args);
    }
}

/**
 * Console Tag used to define the type of message used in
 * the user interface
 */
enum ConsoleTag{
    ERROR("[ERROR]"),
    SYSTEM("[SYSTEM]"),
    INFO("[INFO]");

    /** The label of the ConsoleTag */
    private final String label;

    /** Constructor of the enum */
    ConsoleTag(String label){this.label = label;}

    /** Gets the label of the constant value accessed */
    String label(){return this.label;}
}

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