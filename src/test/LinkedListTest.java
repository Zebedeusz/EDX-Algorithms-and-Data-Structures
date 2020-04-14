package test;

import main.structures.linkedlist.LinkedList;
import main.structures.linkedlist.LinkedListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.helper.Car;

@RunWith(value = JUnit4.class)
public class LinkedListTest {
    private static LinkedList<Car> customList;

    @Before
    public void preps() {
        customList = new LinkedListImpl();
    }

    @Test
    public void shouldAddElementToEmptyList() {
        Car testCar = new Car("x", 8);
        customList.addLast(testCar);
        Assert.assertEquals(testCar, customList.getFirst());
        Assert.assertEquals(testCar, customList.getLast());
    }

    @Test
    public void shouldAddElementToListWithElements() {
        Car testCar = new Car("x", 8);
        Car testCar2 = new Car("z", 5);
        customList.addLast(testCar);
        customList.addLast(testCar2);
        Assert.assertEquals(testCar, customList.getFirst());
        Assert.assertEquals(testCar2, customList.getLast());
    }

    @Test
    public void shouldAddElementAsFirst() {
        Car testCar = new Car("x", 8);
        Car testCar2 = new Car("z", 5);
        customList.addFirst(testCar);
        customList.addFirst(testCar2);
        Assert.assertEquals(testCar2, customList.getFirst());
        Assert.assertEquals(testCar, customList.getLast());
    }

    @Test
    public void shouldAddElementInGivenIndex() {
        Car testCar = new Car("x", 8);
        Car testCar2 = new Car("z", 5);
        Car testCar3 = new Car("t", 1);

        customList.addFirst(testCar);
        customList.addFirst(testCar2);

        customList.add(testCar3, 1);

        Assert.assertEquals(testCar2, customList.getFirst());
        Assert.assertEquals(testCar, customList.getLast());
        Assert.assertEquals(testCar3, customList.get(1));
    }

    @Test
    public void shouldRemoveElement() {
        Car testCar = new Car("x", 8);
        Car testCar2 = new Car("z", 5);
        customList.addLast(testCar);
        customList.addLast(testCar2);
        customList.remove(testCar2);
        Assert.assertEquals(testCar, customList.getLast());
        customList.remove(testCar);
        Assert.assertEquals(null, customList.getLast());
    }

    @Test
    public void shouldRemoveElementFromGivenIndex() {
        Car testCar = new Car("x", 8);
        Car testCar2 = new Car("z", 5);
        customList.addLast(testCar);
        customList.addLast(testCar2);

        customList.remove(0);

        Assert.assertFalse(customList.contains(testCar));
        Assert.assertEquals(1, customList.length());
    }

    @Test
    public void shouldNotRemoveElementWhenItsNotInList() {
        Car testCar = new Car("x", 8);
        Car testCar2 = new Car("z", 5);
        customList.addLast(testCar);
        customList.remove(testCar2);
        Assert.assertEquals(testCar, customList.getFirst());
    }

    @Test
    public void shouldCountElements() {
        Car testCar = new Car("x", 8);
        Car testCar2 = new Car("z", 5);
        customList.addLast(testCar);
        customList.addLast(testCar2);
        Assert.assertEquals(2, customList.length());
    }

    @Test
    public void shouldCheckIfElementIsInList() {
        Car testCar = new Car("x", 8);
        customList.addLast(testCar);
        Assert.assertEquals(true, customList.contains(testCar));
    }
}
