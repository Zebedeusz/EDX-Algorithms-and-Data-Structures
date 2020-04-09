package main.sorting;

public class Selection extends Base{
    // finds lowest element in the collection and places it at the beginning
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array, Class<T> clazz) {
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
}
