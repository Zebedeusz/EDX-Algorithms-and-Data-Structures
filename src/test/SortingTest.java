package test;

import main.sorting.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test.helper.Car;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class SortingTest {

    private static final Integer[] SORTED_INT_ARRAY = {1, 2, 3, 4, 5};
    private static final Integer[] SORTED_INT_ARRAY_DESC = {5, 4, 3, 2, 1};
    private static final Integer[] NOT_SORTED_INT_ARRAY = {1, 3, 5, 2, 4};

    private static final Double[] NOT_SORTED_DOUBLE_ARRAY = {1.0, 3.3, 5.2, 2.1, 4.3};

    private static final String[] NOT_SORTED_STRING_ARRAY = {"aa", "bb", "c", "xoxo"};

    private static final Car[] NOT_SORTED_CUSTOM_TYPE_ARRAY = new Car[4];

    private Base sorting;

    public SortingTest(Base sorting) {
        this.sorting = sorting;
    }

    @Parameterized.Parameters
    public static Iterable<Base> data() {
        return Arrays.asList(new Base[]{new Selection(), new Bubble(), new Merge(), new Quick()});
    }

    @BeforeClass
    public static void preps() {
        NOT_SORTED_CUSTOM_TYPE_ARRAY[0] = new Car("x", 1);
        NOT_SORTED_CUSTOM_TYPE_ARRAY[1] = new Car("j", 8);
        NOT_SORTED_CUSTOM_TYPE_ARRAY[2] = new Car("hhx", 2);
        NOT_SORTED_CUSTOM_TYPE_ARRAY[3] = new Car("yu", 5);
    }

    @Test
    public void shouldNotSortAlreadySortedArray() {
        Integer[] sortingResult = this.sorting.sort(SORTED_INT_ARRAY, Integer.class);
        Assert.assertArrayEquals(SORTED_INT_ARRAY, sortingResult);
    }

    @Test
    public void shouldSortArraySortedDesc() {
        Integer[] sortingResult = this.sorting.sort(SORTED_INT_ARRAY_DESC, Integer.class);
        Assert.assertArrayEquals(SORTED_INT_ARRAY, sortingResult);
    }

    @Test
    public void shouldSortStringArray() {
        String[] sortingResult = this.sorting.sort(NOT_SORTED_STRING_ARRAY, String.class);
        String[] sortedArr = NOT_SORTED_STRING_ARRAY.clone();
        Arrays.sort(sortedArr);
        Assert.assertArrayEquals(sortedArr, sortingResult);
    }

    @Test
    public void shouldSortDoubleArray() {
        Double[] sortingResult = this.sorting.sort(NOT_SORTED_DOUBLE_ARRAY, Double.class);
        Double[] sortedArr = NOT_SORTED_DOUBLE_ARRAY.clone();
        Arrays.sort(sortedArr);
        Assert.assertArrayEquals(sortedArr, sortingResult);
    }

    @Test
    public void shouldSortIntegerArray() {
        Integer[] sortingResult = this.sorting.sort(NOT_SORTED_INT_ARRAY, Integer.class);
        Assert.assertArrayEquals(SORTED_INT_ARRAY, sortingResult);
    }

    @Test
    public void shouldSortCustomTypeArray() {
        Car[] sortingResult = this.sorting.sort(NOT_SORTED_CUSTOM_TYPE_ARRAY, Car.class);
        Car[] sortedArr = NOT_SORTED_CUSTOM_TYPE_ARRAY.clone();
        Arrays.sort(sortedArr);
        Assert.assertArrayEquals(sortedArr, sortingResult);
    }
}
