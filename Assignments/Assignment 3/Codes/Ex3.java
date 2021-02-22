
/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Assignment 3
 ******************************************************************************/

public class Ex3 {

    public static void main(String[] args) {

        //test 0
        MyNode root = null;
        System.out.println("returns " + isFull(root) + " with empty tree");

        //test1
        MyNode root1 = null;
        root1 = new MyNode(1);
        System.out.println("returns " + isFull(root1) + " with full tree which height equals 0 (only shoresh)");

        //test2
        MyNode root2 = null;
        root2 = new MyNode(1);
        root2.left = new MyNode(2);
        root2.right = new MyNode(3);
        System.out.println("returns " + isFull(root2) + " with full tree which height equals 1");

        //test3
        MyNode root3 = null;
        root3 = new MyNode(1);
        root3.left = new MyNode(2);
        root3.right = new MyNode(3);
        root3.left.left = new MyNode(4);
        root3.left.right = new MyNode(5);
        root3.right.left = new MyNode(6);
        root3.right.right = new MyNode(7);
        System.out.println("returns " + isFull(root3) + " with full tree which height equals 2");

        //test4
        MyNode root4 = null;
        root4 = new MyNode(1);
        root4.left = new MyNode(2);
        System.out.println("returns " + isFull(root4) + " with tree not full");

        //test5
        MyNode root5 = null;
        root5 = new MyNode(1);
        root5.left = new MyNode(2);
        root5.right = new MyNode(3);
        root5.left.left = new MyNode(4);
        System.out.println("returns " + isFull(root5) + " with tree not full");

        //test6
        MyNode root6 = null;
        root6 = new MyNode(1);
        root6.right = new MyNode(3);
        root6.right.left = new MyNode(6);
        root6.right.right = new MyNode(7);
        System.out.println("returns " + isFull(root6) + " with tree not full");
    }


    //checks if a BT is full
    public static int isFull(MyNode root) {
        int d = depth(root);
        if (is_perfect(root, d, 0)) return d - 1;
        else return -2;
    }

    // Calculate the depth of the leaf at the very left
    public static int depth(MyNode node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }


    // Checks if the tree is perfect recursively
    static boolean is_perfect(MyNode root, int d, int count) {

        // Empty tree is perfect
        if (root == null)
            return true;

        // If children are null return true if depth = count+1, else return false.
        if (root.left == null && root.right == null)
            return (d == count + 1);

        //if right children or left children is null return false
        if (root.left == null || root.right == null)
            return false;

        return is_perfect(root.left, d, count + 1) && is_perfect(root.right, d, count + 1);
    }

}
