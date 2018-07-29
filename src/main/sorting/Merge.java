package main.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Merge extends Base {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array, Class<T> clazz) {
        return merge(
                Arrays.copyOfRange(array, 0,array.length/2),
                Arrays.copyOfRange(array,array.length/2, array.length), clazz);
    }

    private <T extends Comparable<T>> T[] merge(T[] firstHalf, T[] secondHalf, Class<T> clazz) {
        if (firstHalf.length > 2) {
            firstHalf = merge(
                    Arrays.copyOfRange(firstHalf, 0, firstHalf.length / 2),
                    Arrays.copyOfRange(firstHalf, firstHalf.length / 2, firstHalf.length), clazz);
        }
        if (secondHalf.length > 2) {
            secondHalf = merge(
                    Arrays.copyOfRange(secondHalf, 0, secondHalf.length / 2),
                    Arrays.copyOfRange(secondHalf, secondHalf.length / 2, secondHalf.length), clazz);
        }
        T[] sorted = (T[]) Array.newInstance(clazz, firstHalf.length + secondHalf.length);
        int j = 0;
        int i = 0;
        int k = 0;
        while (i < firstHalf.length && j < secondHalf.length) {
            if(firstHalf[i].compareTo(secondHalf[j]) > 0) {
                sorted[k++] = secondHalf[j++];
            }
            else {
                sorted[k++] = firstHalf[i++];
            }
        }
        while (i < firstHalf.length) {
            sorted[k++] = firstHalf[i++];
        }
        while (j < secondHalf.length) {
            sorted[k++] = secondHalf[j++];
        }
        return sorted;
    }
}
