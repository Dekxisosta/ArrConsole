package app;

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