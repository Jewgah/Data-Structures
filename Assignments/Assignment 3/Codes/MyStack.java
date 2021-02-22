
/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Assignment 3
 ******************************************************************************/

public class MyStack {

    private int[] a;
    private int p;

    public MyStack(int capacity) {
        a = new int[capacity];
        p = 0;
    }

    // basic stack

    public boolean push(int data) {
        if (p == a.length) return false;
        else {
            a[p++] = data;
            return true;
        }
    }

    public int pop() {
        if (p == 0) return Integer.MAX_VALUE;
        else return a[--p];
    }
}
