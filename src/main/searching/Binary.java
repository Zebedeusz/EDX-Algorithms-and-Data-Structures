package main.searching;

public class Binary extends Base {
    @Override
    public <T extends Comparable<T>> int search(T[] array, T toFind){
        int foundAt = -1;
        int index = array.length / 2;
        while(foundAt == -1 && (index > 0 && index < array.length)) {
            if(array[index].compareTo(toFind) == 0) {
                foundAt = index;
            }
            else if(array[index].compareTo(toFind) > 0) {
                index -= index / 2;
            }
            else if(array[index].compareTo(toFind) < 0) {
                index += index / 2;
            }
        }
        return foundAt;
    }
}
