
/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Assignment 3
 ******************************************************************************/

public class MyQueue {

    private MyStack Stack1, Stack2;


    public MyQueue(int capacity) {
        this.Stack1 = new MyStack(capacity);
        this.Stack2 = new MyStack(capacity);
    }

    public boolean enqueue(int data) {
        //add data to top of Stack1
        return Stack1.push(data);
    }


    public int dequeue() {

        int temp = Stack1.pop();

        //fills Stack 2 with reversed Stack1 while Stack1 isn't empty
        while (temp != Integer.MAX_VALUE) {
            Stack2.push(temp);
            temp = Stack1.pop();
        }

        //get top element of Stack2
        int out = Stack2.pop();

        // put back all remaining elements in Stack1

        int temp2 = Stack2.pop();

        while (temp2 != Integer.MAX_VALUE) {
            Stack1.push(temp2);
            temp2 = Stack2.pop();
        }

        return out;
    }
}
