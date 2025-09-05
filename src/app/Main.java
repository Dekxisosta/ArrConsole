package app;

/**
 * Runs the program. The orchestrator of all classes
 * in the Main file
 */
public class Main {
    /** Determines program continuation */
    private static boolean isContinueProgram = true;

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
        Actions.defineArrayWithSize();
        Actions.getNumbers();


        while(isContinueProgram){
            //Shows banner and menu
            UI.showBanner(Properties.getProgramName());
            UI.showMenu(Properties.getActionNames());

            //Shows enter prompt
            UI.showEnterPrompt("your choice");

            //Performs an action based on user input
            isContinueProgram = Menu.performActionFromMenu(Validator.getInt(0, Properties.getActionNames().length));
        }
        UI.showMessage(ConsoleTag.SYSTEM, "Thank you for using the program!");
        Input.close();
    }
}