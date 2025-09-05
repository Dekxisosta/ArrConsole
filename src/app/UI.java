package app;

/**
 * Renders visual output in the console
 */
class UI {
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