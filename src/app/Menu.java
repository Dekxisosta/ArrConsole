package app;

/**
 * Serves as a map of actions
 * @see Actions
 */
class Menu{
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
    static boolean performActionFromMenu(int choice) {
        switch (choice) {
            //Sets array size and numbers
            case 1:
                Actions.defineArrayWithSize();
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
                return Actions.setContinueProgram();
        }
        return true;
    }
}
