package main.dataStructures;

public interface LinkedList<E> {
    void addFirst(Object obj);

    void addLast(Object obj);

    void add(Object obj, int index);

    void remove(Object obj);

    void remove(int index);

    int length();

    boolean contains(Object obj);

    Object getFirst();

    Object getLast();

    Object get(int index);
}
