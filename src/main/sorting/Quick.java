package main.sorting;

import org.apache.commons.lang3.ArrayUtils;

public class Quick extends Base {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array, Class<T> clazz) {
        T[] arrayCopy = ArrayUtils.clone(array);

        if (arrayCopy.length < 2) {
            return arrayCopy;
        }

        int beforeBiggerThanPivotIndex = 0;
        int pivotIndex = (int) (Math.random() * (arrayCopy.length - 1));

//        pivot has to be the first element, otherwise it would have to be skipped in the loop differently
        if (pivotIndex != 0) {
            T pivotValue = arrayCopy[pivotIndex];
            arrayCopy[pivotIndex] = arrayCopy[0];
            arrayCopy[0] = pivotValue;
            pivotIndex = 0;
        }
//        starting from index = 1 so as to skip the pivot
        for (int i = 1; i < arrayCopy.length; i++) {
//            only when value at i < pivot so as to separate values smaller than pivot from bigger than it
//            - not necessary to do anything when it's bigger
            if (arrayCopy[i].compareTo(arrayCopy[pivotIndex]) < 0) {
//              swap element smaller than pivot - i - with first element bigger than pivot - arrayCopy[beforeBiggerThanPivotIndex + 1]
                T firstBiggerThanPivotValue = arrayCopy[beforeBiggerThanPivotIndex + 1];
                arrayCopy[beforeBiggerThanPivotIndex + 1] = arrayCopy[i];
                arrayCopy[i] = firstBiggerThanPivotValue;

                beforeBiggerThanPivotIndex++;
            }
        }

//        put pivot between elements smaller than it and bigger than it - in the middle
        T pivotValue = arrayCopy[pivotIndex];
        arrayCopy[pivotIndex] = arrayCopy[beforeBiggerThanPivotIndex];
        arrayCopy[beforeBiggerThanPivotIndex] = pivotValue;
        pivotIndex = beforeBiggerThanPivotIndex;

        T[] leftSortedArray = this.sort(ArrayUtils.subarray(arrayCopy, 0, pivotIndex), clazz);
        T[] rightSortedArray = this.sort(ArrayUtils.subarray(arrayCopy, pivotIndex + 1, arrayCopy.length), clazz);
        T[] pivoted = ArrayUtils.add(leftSortedArray, arrayCopy[pivotIndex]);
        pivoted = ArrayUtils.addAll(pivoted, rightSortedArray);

        return pivoted;
    }
}