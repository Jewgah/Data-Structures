package Stack;

/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Generic Stack implementation using an Array
 ******************************************************************************/

public class Stack_array<T> {
    private Object A[];
    private int size;

    public Stack_array(int capacity) {
        A = new Object[capacity];
        size = 0;
    }

    public boolean push(T key) {
        if (size == A.length) return false;
        A[size++] = key;
        return true;
    }

    public T pop() {
        if (size == 0) return null;
        return (T) A[--size];
    }

    public boolean contains(T key) {
        for (int i = 0; i < size; i++)
            if (A[i].equals(key))
                return true;
        return false;
    }

    public T peek() {
        if (size == 0) return null;
        return (T) A[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public int capacity() {
        return A.length;
    }

}