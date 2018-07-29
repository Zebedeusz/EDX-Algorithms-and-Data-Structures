package main.sorting;

public class Bubble extends Base {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array, Class<T> clazz) {
        int changes = 1;
        while (changes > 0) {
            changes = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    changes++;
                }
            }
        }
        return array;
    }
}
