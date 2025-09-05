package app;

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
        for (int i = 0 ; i < Data.getArraySize(); i++)
            if (countElement == Data.getNumbers()[i])
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

        for (int i = 0; i < Data.getNumbers().length; i++) {
            if (Data.getNumbers()[i] == element) {
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
        for (int i = 0; i < Data.getArraySize(); i++) {
            boolean isPrinted = false;

            for (int k = 0; k < i; k++) {
                if (Data.getNumbers()[i] == Data.getNumbers()[k]) {
                    isPrinted = true;
                    break;
                }
            }

            if (isPrinted)
                continue;

            // Compare with next elements
            for (int j = i + 1; j < Data.getNumbers().length; j++) {
                if (Data.getNumbers()[i] == Data.getNumbers()[j]) {
                    if (!isFirst) {
                        UI.printf(", ");
                    }
                    UI.printf(String.valueOf(Data.getNumbers()[i]));
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

        for (int i = 0; i < Data.getNumbers().length - 1; i++) {
            currentOccurrences = 1;

            for (int j = i + 1; j < Data.getNumbers().length; j++) {
                //checks if element is equal
                if (Data.getNumbers()[i] == Data.getNumbers()[j]) {
                    currentOccurrences++;
                }
                //checks if greater than current most occurrences
                if(currentOccurrences > mostOccurrences){
                    mostOccurrences = currentOccurrences;
                    indexOfMostOccurred = i;
                }
            }
        }
        UI.printf("%nMost occurring element: %d (occurs %d times)", Data.getNumbers()[indexOfMostOccurred], mostOccurrences);
    }

    /** Shows the first non-repeating element in the array */
    static void showFirstNonRepeatingElement(){
        boolean isNonRepeating = false; //initialized as false for possible no non-repeating elements in the array

        for(int i=0; i < Data.getNumbers().length; i++){
            isNonRepeating = true; // set to true for program loop
            for(int j=0; j < Data.getNumbers().length; j++){
                if(Data.getNumbers()[i] == Data.getNumbers()[j] && i!=j){// if repeating, then set to false
                    isNonRepeating = false;
                    break;
                }
            }
            if(isNonRepeating){
                UI.printf("%nThe first non-repeating element is: %s ", Data.getNumbers()[i]);
                break;
            }
        }

        if(!isNonRepeating)
            UI.printf("%nThere are no non-repeating elements in the array");
    }

    /** Gets the array size for program runtime */
    static void defineArrayWithSize(){
        UI.showMessage(ConsoleTag.SYSTEM, "Input array size");
        UI.showEnterPrompt("size");
        Data.setArraySize(Validator.getInt(0, Properties.getMaxArraySize()));
        Data.setNumbers(new int[Data.getArraySize()]);
    }
    /** Gets the numbers for the array */
    static void getNumbers(){
        UI.showMessage(ConsoleTag.SYSTEM, "Input numbers");
        for(int i=0; i<Data.getArraySize(); i++){
            UI.showEnterPrompt("value for index " + i + ": ");
            Data.setIndex(i, Validator.getInt());
        }
    }
    static void viewNumbers(){
        UI.showMessage(ConsoleTag.INFO, "Showing values of numbers array");
        for(int i=0; i<Data.getArraySize(); i++){
            UI.printf("%nIndex %s: %s", i, Data.getNumbers()[i]);
        }
    }
    /** Set continue program based on boolean input */
    static boolean setContinueProgram(){
        UI.showMessage(ConsoleTag.SYSTEM, "Quit Program? (y/n) ");
        return !Validator.getBoolean();
    }
}