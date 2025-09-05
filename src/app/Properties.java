package app;

/**
 * Properties of the system like program name, etc.
 */
class Properties{
    /** Program name for value */
    private static final String PROGRAM_NAME = "Array Manipulation Program";

    /**
     * Container for action names, used when displaying options, and
     * determining switch-case statement length
     */
    private static String[] actionNames = {
            "Terminate Program", // must be on top for value 0 in actionMenu showOptions
            "Set Array Size and Numbers",
            "View Numbers",
            "Show Count of Occurrences of an Element",
            "Show Indices of All Occurrences of an Element",
            "Show Elements with Duplicates",
            "Show the Most Occurring element in the Array",
            "Show First non-repeating element in the Array"
    };

    /** The maximum capacity the array can have */
    private static int MAX_ARRAY_SIZE = 20;

    /** @return MAX_ARRAY_SIZE the maximum array size */
    static int getMaxArraySize() {return MAX_ARRAY_SIZE;}

    /** Gets program name */
    static String getProgramName(){ return PROGRAM_NAME;}

    /** Gets action names */
    static String[] getActionNames(){ return actionNames; }
}