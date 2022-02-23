package classess;

import java.util.Arrays;

//Dynamic Array class
//I created this class to learn this Data Structure

public class DynamicArray {
    private int array[];
    private int size;
    private int capacity;

    DynamicArray() {
        array = new int[2];
        size = 0;
        capacity = 2;
    }

    public void addElementByValue(int elem) {
        if (size == capacity) {
            int[] tmpArray = new int[capacity * 2];
            for (int i = 0; i < size; i++) {
                tmpArray[i] = array[i];
            }
            array = tmpArray;
            capacity = (int)(capacity * 2);
        }
        array[size] = elem;
        size++;
    }

    public void updateElementByIndex(int elem, int index) {
        if (index >= capacity) {
            return;
        }
        if (index >= 0 && index < size) {
            array[index] = elem;
        }
    }

    public void addElementByIndex(int elem, int index) {
        if (size == capacity) {
            int[] tmpArray = new int[(int)(capacity * 2)];
            for (int i = 0; i < size; i++) {
                tmpArray[i] = array[i];
            }
            array = tmpArray;
            capacity = (int)(capacity * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = elem;
        size++;

    }

    public void removeElementByIndex(int index) {
        if (index >= 0 && index < size) {
            int[] tmpArray = new int[capacity];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = 0;
            size--;
        } else {
            System.out.println("No element was found");
        }
    }

    //deletes the first occurrence of a element
    public void removeElementByValue(int elem) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == elem) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("No such element");
        } else {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = 0;
            size--;
        }
    }

    //deletes unused space; shrinking the array;
    public void shrinkArray() {
        int tmpArray[] = new int[size];
        for (int i = 0; i < size; i++) {
            tmpArray[i] = array [i];
        }
        array = tmpArray;
        capacity = array.length;
    }

    public void printArray() {
        System.out.println("Array output is: " + Arrays.toString(array));
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
