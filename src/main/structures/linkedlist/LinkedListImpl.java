package main.structures.linkedlist;

public class LinkedListImpl implements LinkedList {
    private Node first;

    @Override
    public void addLast(Object obj) {
        if (this.first == null) {
            this.first = new Node(null, obj);
            return;
        }
        Node last = first;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new Node(null, obj);
    }

    @Override
    public void addFirst(Object obj) {
        if (this.first == null) {
            this.first = new Node(null, obj);
            return;
        }
        this.first = new Node(this.first, obj);
    }

    @Override
    public void add(Object obj, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            if (this.first == null) {
                this.first = new Node(null, obj);
                return;
            } else {
                this.first = new Node(this.first, obj);
                return;
            }
        }
        int k = 1;
        Node last = this.first;
        while (last.next != null) {
            if (k == index) {
                last.next = new Node(last.next, obj);
                return;
            }
            last = last.next;
            k++;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void remove(Object obj) {
        if (this.first.value.equals(obj)) {
            this.first = this.first.next;
            return;
        }
        Node last = this.first;
        while (last != null) {
            if (last.next != null && obj.equals(last.next.value)) {
                last.next = last.next.next;
                return;
            }
            last = last.next;
        }
    }

    @Override
    public void remove(int index) {
        if (this.length() - 1 < index) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            if (this.first != null) {
                this.first = this.first.next;
                return;
            }
        }
        int k = 1;
        Node last = this.first;
        while (last.next != null) {
            if (k == index) {
                last.next = last.next.next;
                return;
            }
            last = last.next;
            k++;
        }
    }

    @Override
    public int length() {
        int length = 0;
        Node last = this.first;
        while (last != null) {
            length++;
            last = last.next;
        }
        return length;
    }

    @Override
    public boolean contains(Object obj) {
        boolean in = false;
        Node last = this.first;
        while (last != null) {
            if (obj.equals(last.value)) {
                in = true;
            }
            last = last.next;
        }
        return in;
    }

    @Override
    public Object getFirst() {
        return this.first.value;
    }

    @Override
    public Object getLast() {
        if (this.first == null)
            return null;
        Node last = this.first;
        while (last.next != null) {
            last = last.next;
        }
        return last.value;
    }

    @Override
    public Object get(int index) {
        if (this.length() - 1 < index) {
            throw new IndexOutOfBoundsException();
        }
        int k = 0;
        Node last = this.first;
        while (last != null) {
            if (k == index) {
                break;
            }
            last = last.next;
            k++;
        }
        return last.value;
    }


    private class Node {
        private Node next;
        private Object value;

        Node(Node next, Object value) {
            this.next = next;
            this.value = value;
        }
    }
}
