package app;

/**
 * Centralized data class for the array.
 * No accessor functions added due to time constraints
 */
class Data{
    /** The size of the array */
    private static int arraySize = 0;

    /** The datastore for all integer inputs */
    private static int[] numbers;

    /** @return arraySize of numbers */
    static int getArraySize() {return arraySize;}

    /** @return numbers the array of numbers */
    static int[] getNumbers() {return numbers;}

    /** @param size the new number size */
    static void setArraySize(int size) {
        arraySize = size;
        numbers = new int[arraySize];
    }

    /** @param newNumbers the new array with size */
    static void setNumbers(int[] newNumbers) {
        numbers = newNumbers;
    }

    /**
     * @param index the new array with size
     * @param value the value of the index
     */
    static void setIndex(int index, int value){
        numbers[index] = value;
    }
}