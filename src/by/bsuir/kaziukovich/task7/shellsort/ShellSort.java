package by.bsuir.kaziukovich.task7.shellsort;

/**
 * Class with Shell sort implementation
 */
public class ShellSort {
    /**
     * Method to sort double array
     * @param array Array to sort
     */
    public static void sort(double[] array) {
        int currentIndex = 0;
        double buffer;

        if (array == null) {
            throw new IllegalArgumentException("Array shouldn't be null");
        }

        while (currentIndex < (array.length - 1)) {
            if (array[currentIndex] <= array[currentIndex + 1]) {
                currentIndex++;
            } else {
                buffer = array[currentIndex];
                array[currentIndex] = array[currentIndex + 1];
                array[currentIndex + 1] = buffer;
                if (currentIndex > 0) {
                    currentIndex--;
                }
            }
        }
    }

    /**
     * Private constructor to prevent object creation
     */
    private ShellSort() {}
}
