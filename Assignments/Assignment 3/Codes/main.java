
/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Assignment 3
 ******************************************************************************/

public class main {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue(10);

        queue.enqueue(1);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(55);
        queue.enqueue(100);
        queue.enqueue(500);
        queue.enqueue(28);
        queue.enqueue(13);

        System.out.println("removedInt = " + queue.dequeue());
        System.out.println("removedInt = " + queue.dequeue());
        System.out.println("removedInt = " + queue.dequeue());
        System.out.println("removedInt = " + queue.dequeue());
        System.out.println("removedInt = " + queue.dequeue());
        System.out.println("removedInt = " + queue.dequeue());
        System.out.println("removedInt = " + queue.dequeue());
        System.out.println("removedInt = " + queue.dequeue());
        System.out.println("removedInt (the stack is empty) = " + queue.dequeue());

    }

}
