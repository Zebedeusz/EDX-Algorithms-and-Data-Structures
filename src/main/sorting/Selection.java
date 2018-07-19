package main.sorting;

public class Selection {

    // finds lowest element in the collection and places it at the beginning
    public static <T extends Comparable<T>> T[] sort(T[] array) {
        // steps:
        // find min in array i - n
        // assign min to first index in array
        // i++
        for (int i = 0; i < array.length; i++) {
            T min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min.compareTo(array[j]) > 0) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (array[i].compareTo(min) != 0) {
                T tempVal = array[i];
                array[i] = min;
                array[minIndex] = tempVal;
            }
        }
        return array;
    }

    public static double[] sort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            double min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (array[i] != min) {
                double tempVal = array[i];
                array[i] = min;
                array[minIndex] = tempVal;
            }
        }
        return array;
    }

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (array[i] != min) {
                int tempVal = array[i];
                array[i] = min;
                array[minIndex] = tempVal;
            }
        }
        return array;
    }
}
