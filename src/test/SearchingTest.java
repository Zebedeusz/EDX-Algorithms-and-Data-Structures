package test;

import main.searching.Binary;
import main.searching.Base;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import test.helper.Car;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class SearchingTest {

    private static final Integer[] SORTED_INT_ARRAY = {1, 2, 3, 4, 5};

    private static final Double[] SORTED_DOUBLE_ARRAY = {1.0, 3.3, 5.2, 7.0, 12.8};

    private static final String[] SORTED_STRING_ARRAY = {"aa", "bb", "c", "xoxo"};

    private static final Car[] SORTED_CUSTOM_TYPE_ARRAY = new Car[4];

    private Base searching;

    public SearchingTest(Base searching) {
        this.searching = searching;
    }

    @Parameterized.Parameters
    public static Iterable<Base> data() {
        return Arrays.asList(new Base[]{new Binary()});
    }

    @BeforeClass
    public static void preps() {
        SORTED_CUSTOM_TYPE_ARRAY[0] = new Car("a", 1);
        SORTED_CUSTOM_TYPE_ARRAY[1] = new Car("b", 1);
        SORTED_CUSTOM_TYPE_ARRAY[2] = new Car("c", 1);
        SORTED_CUSTOM_TYPE_ARRAY[3] = new Car("d", 1);
    }

    @Test
    public void shouldFindElementInIntegerArray() {
        int searchingResult = this.searching.search(SORTED_INT_ARRAY, SORTED_INT_ARRAY[4]);
        Assert.assertEquals(4, searchingResult);
    }

    @Test
    public void shouldFindElementInDoubleArray() {
        int searchingResult = this.searching.search(SORTED_DOUBLE_ARRAY, SORTED_DOUBLE_ARRAY[1]);
        Assert.assertEquals(1, searchingResult);
    }

    @Test
    public void shouldFindElementInStringArray() {
        int searchingResult = this.searching.search(SORTED_STRING_ARRAY, SORTED_STRING_ARRAY[2]);
        Assert.assertEquals(2, searchingResult);
    }

    @Test
    public void shouldFindElementInCustomArray() {
        int searchingResult = this.searching.search(SORTED_CUSTOM_TYPE_ARRAY, SORTED_CUSTOM_TYPE_ARRAY[3]);
        Assert.assertEquals(3, searchingResult);
    }

    @Test
    public void shouldNotFindElementIfNotInArray() {
        int searchingResult = this.searching.search(SORTED_INT_ARRAY, 500);
        Assert.assertEquals(-1, searchingResult);
    }
}
