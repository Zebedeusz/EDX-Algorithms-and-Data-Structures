package main.searching;

public abstract class Base {
    public abstract <T extends Comparable<T>> int search(T[] array, T toFind);
}
