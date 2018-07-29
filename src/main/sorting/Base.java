package main.sorting;

public abstract class Base {
    public abstract <T extends Comparable<T>> T[] sort(T[] array, Class<T> clazz);
}
