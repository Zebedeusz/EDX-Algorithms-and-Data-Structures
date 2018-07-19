package test;

import main.sorting.Selection;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.helper.Car;
import org.junit.Assert;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class SelectionTests {

    private static final int[] SORTED_INT_ARRAY = {1, 2, 3, 4, 5};
    private static final int[] SORTED_INT_ARRAY_DESC = {5, 4, 3, 2, 1};
    private static final int[] NOT_SORTED_INT_ARRAY = {1, 3, 5, 2, 4};

    private static final double[] NOT_SORTED_DOUBLE_ARRAY = {1.0, 3.3, 5.2, 2.1, 4.3};

    private static final String[] NOT_SORTED_STRING_ARRAY = {"aa", "bb", "c", "xoxo"};

    private static final Car[] NOT_SORTED_CUSTOM_TYPE_ARRAY = new Car[4];

    @BeforeClass
    public static void preps() {
        NOT_SORTED_CUSTOM_TYPE_ARRAY[0] = new Car("x", 1);
        NOT_SORTED_CUSTOM_TYPE_ARRAY[1] = new Car("j", 8);
        NOT_SORTED_CUSTOM_TYPE_ARRAY[2] = new Car("hhx", 2);
        NOT_SORTED_CUSTOM_TYPE_ARRAY[3] = new Car("yu", 5);
    }

    @Test
    public void shouldNotSortAlreadySortedArray() {
        int[] sortingResult = Selection.sort(SORTED_INT_ARRAY);
        Assert.assertArrayEquals(sortingResult, SORTED_INT_ARRAY);
    }

    @Test
    public void shouldSortArraySortedDesc() {
        int[] sortingResult = Selection.sort(SORTED_INT_ARRAY_DESC);
        Assert.assertArrayEquals(sortingResult, SORTED_INT_ARRAY);
    }

    @Test
    public void shouldSortStringArray() {
        String[] sortingResult = Selection.sort(NOT_SORTED_STRING_ARRAY);
        String[] sortedArr = NOT_SORTED_STRING_ARRAY.clone();
        Arrays.sort(sortedArr);
        Assert.assertArrayEquals(sortingResult, sortedArr);
    }

    @Test
    public void shouldSortDoubleArray() {
        double[] sortingResult = Selection.sort(NOT_SORTED_DOUBLE_ARRAY);
        double[] sortedArr = NOT_SORTED_DOUBLE_ARRAY.clone();
        Arrays.sort(sortedArr);
        Assert.assertArrayEquals(sortingResult, sortedArr, 0.000005);
    }

    @Test
    public void shouldSortIntegerArray() {
        int[] sortingResult = Selection.sort(NOT_SORTED_INT_ARRAY);
        Assert.assertArrayEquals(sortingResult, SORTED_INT_ARRAY);
    }

    @Test
    public void shouldSortCustomTypeArray() {
        Car[] sortingResult = Selection.sort(NOT_SORTED_CUSTOM_TYPE_ARRAY);
        Car[] sortedArr = NOT_SORTED_CUSTOM_TYPE_ARRAY.clone();
        Arrays.sort(sortedArr);
        Assert.assertArrayEquals(sortingResult, sortedArr);
    }
}
