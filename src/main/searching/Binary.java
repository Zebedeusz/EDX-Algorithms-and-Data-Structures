package main.searching;

public class Binary extends Base {
    @Override
    public <T extends Comparable<T>> int search(T[] array, T toFind){
        int foundAt = -1;
        int index = array.length / 2;
        int prevIndex = index;
        while (foundAt == -1 && (index >= 0 && index < array.length)) {
            prevIndex = index;
            if (array[index].compareTo(toFind) == 0) {
                foundAt = index;
            } else if (array[index].compareTo(toFind) > 0) {
                index -= index / 2;
            } else if (array[index].compareTo(toFind) < 0) {
                index += index / 2;
            }
            if (prevIndex == index) {
                break;
            }
        }
        return foundAt;
    }
}
