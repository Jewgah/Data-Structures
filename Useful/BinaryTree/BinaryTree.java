package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Binary Tree Implementation
 ******************************************************************************/
public class BinaryTree {
    public BTNode root;

    public BinaryTree() {
        root = null;
    }

    public void Add(int data) {
        BTNode newNode = new BTNode(data);
        boolean flag = false;

        BTNode p = this.root;
        if (p == null) {
            this.root = newNode;
            return;
        }
        while (!flag) {
            if (Math.random() > 0.5) {// turn right
                if (p.getRight() == null) {
                    p.setRight(newNode);
                    flag = true;
                } else {
                    p = p.getRight();
                }
            } else {// turn left
                if (p.getLeft() == null) {
                    p.setLeft(newNode);
                    flag = true;
                } else {
                    p = p.getLeft();
                }
            }
        }
    }

    public void AddRecursive(int data) {
        BTNode newNode = new BTNode(data);
        if (root == null) {
            root = newNode;
            return;
        }
        BTNode currNode = root;
        AddRecursive(newNode, currNode);
    }

    private void AddRecursive(BTNode newNode, BTNode currNode) {
        if (Math.random() > 0.5) {
            if (currNode.getRight() == null) {
                currNode.setRight(newNode);
                return;
            }
            AddRecursive(newNode, currNode.getRight());
        } else {
            if (currNode.getLeft() == null) {
                currNode.setLeft(newNode);
                return;
            }
            AddRecursive(newNode, currNode.getLeft());
        }

    }

    public void PrintPreOrder() {
        PrintPreOrder(root);
    }

    private void PrintPreOrder(BTNode parent) {
        if (parent != null) {
            System.out.print(parent.getData() + " ");
            PrintPreOrder(parent.getLeft());
            PrintPreOrder(parent.getRight());
        }
    }

    public void PrintInOrder() {
        PrintInOrder(root);
    }

    private void PrintInOrder(BTNode parent) {
        if (parent != null) {
            PrintInOrder(parent.getLeft());
            System.out.print(parent + " ");
            PrintInOrder(parent.getRight());
        }
    }

    public void PrintPostOrder() {
        PrintPostOrder(root);
    }

    private void PrintPostOrder(BTNode parent) {
        if (parent != null) {
            PrintPostOrder(parent.getLeft());
            PrintPostOrder(parent.getRight());
            System.out.print(parent + " ");
        }
    }

    public void PrintLevelOrder() {
        PrintLevelOrder(root);
    }

    private void PrintLevelOrder(BTNode root) {
        if (root == null) return;
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            for (int n = q.size(); n > 0; n--) {
                BTNode top = q.poll();
                System.out.print(top + " ");
                if (top.getLeft() != null) q.add(top.getLeft());
                if (top.getRight() != null) q.add(top.getRight());
            }
            System.out.println();
        }

    }

    /* checks if the tree is binary search tree ("sorted") */
    public boolean isBst() {
        return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBst(BTNode root, int min, int max) {
        if (root == null) return true;
        if (root.getData() < min || root.getData() > max) return false;
        return isBst(root.getLeft(), min, root.getData() - 1) &&
                isBst(root.getRight(), root.getData() + 1, max);
    }

    /* Returns the height of the tree */
    public int height() {
        return height(root);
    }

    private int height(BTNode p) {
        if (p != null) {
            return 1 + Math.max(height(p.getLeft()), height(p.getRight()));
        }
        return 0;
    }

    /* Printing the tree visualy */
    public void printBinaryTree() {
        System.out.println("================================");
        printBinaryTree(root, 0);
        System.out.println("================================");
    }

    public void printBinaryTree(BTNode root, int level) {
        if (root == null)
            return;
        printBinaryTree(root.getRight(), level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------" + root.getData());
        } else
            System.out.println(root.getData());
        printBinaryTree(root.getLeft(), level + 1);
    }

    public void removeContent(int d) {

    }

    /* Counting nodes that holds input data */
    public int countContent(int d) {
        return countContent(root, d);
    }

    private int countContent(BTNode p, int d) {
        if (p != null) {
            int t = 0;
            if (p.getData() == d) t = 1;
            return t + countContent(p.getLeft(), d) + countContent(p.getRight(), d);
        }
        return 0;
    }

    /* Counting total nodes */
    public int countTotalNodes() {
        return countNodes(root);
    }

    private int countNodes(BTNode p) {
        if (p != null)
            return 1 + countNodes(p.getRight()) + countNodes(p.getLeft());
        return 0;
    }

    /* Counting all outside nodes */
    public int countOutsidesNodes() {
        return countOutside(root, 0) + countOutside(root, 1) - 1;
    }

    private int countOutside(BTNode p, int n) {
        if (p == null) return 0;
        if (n == 1) return 1 + countOutside(p.getRight(), 1);
        return 1 + countOutside(p.getLeft(), 0);
    }

    /* Counting all inner nodes */
    public int countInnerNodes() {
        return countNodes(root) - countOutsidesNodes();
    }

    /* Printing all values in a given tree level */
    public void printLevel(int i) {
        printLevel(root, i);
    }

    private void printLevel(BTNode root, int i) {
        if (root != null) {
            if (i == 0) {
                System.out.print(root.getData() + " ");
                return;
            }
            printLevel(root.getLeft(), i - 1);
            printLevel(root.getRight(), i - 1);
        }
    }

    /* Check if the tree contains a given value */
    public boolean contains(int data) {
        return contains(root, data);
    }

    private boolean contains(BTNode root, int data) {
        if (root == null) return false;
        if (root.getData() == data) return true;
        return contains(root.getRight(), data) || contains(root.getLeft(), data);
    }

    /* Counting parents having only one child */
    public int oneChildParents() {
        return oneChild(root);
    }

    private int oneChild(BTNode root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null))
            return 0;
        if (root.getLeft() == null)
            return 1 + oneChild(root.getRight());
        if (root.getRight() == null)
            return 1 + oneChild(root.getLeft());
        return oneChild(root.getRight()) + oneChild(root.getLeft());
    }

    /* Check if two given values are cousins */
    /* Cousins := Same grandfather but different parents */
    public boolean areCousins(int i, int j) {
        return areCousins(root, i, j);
    }

    private boolean areCousins(BTNode root, int i, int j) {
        if (root.getLeft() == null || root.getRight() == null) return false;
        boolean a = hasChild(root.getLeft(), i) && hasChild(root.getRight(), j);
        boolean b = hasChild(root.getRight(), i) && hasChild(root.getLeft(), j);
        if (a || b) return true;
        boolean c = areCousins(root.getLeft(), i, j);
        boolean d = areCousins(root.getRight(), i, j);
        return c || d;
    }

    private boolean hasChild(BTNode root, int i) {
        if (root.getRight() != null)
            if (root.getRight().getData() == i)
                return true;
        if (root.getLeft() != null)
            if (root.getLeft().getData() == i)
                return true;
        return false;
    }

    /* return the maximum path's sum */
    public int maxSumPath() {
        return maxSum(root);
    }

    private int maxSum(BTNode root) {
        if (root == null) return 0;
        return root.getData() + Math.max(maxSum(root.getLeft()), maxSum(root.getRight()));
    }

    /* Check if there is a path contaning an int array elements (by order)*/
    public boolean isPathContains(int[] a) {
        return isPathContains(root, a, 0);
    }

    private boolean isPathContains(BTNode root, int[] a, int l) {
        if (root == null) return false;
        if (l == a.length - 1 && a[l] == root.getData()) return true;
        if (root.getData() == a[l]) {
            return isPathContains(root.getLeft(), a, l + 1) || isPathContains(root.getRight(), a, l + 1);
        }
        return isPathContains(root.getLeft(), a, l) || isPathContains(root.getRight(), a, l);
    }

    /* returning the longest path from root to leaf as array */
    public int[] longestPath() {
        int h = height();
        ArrayList<Integer> a = new ArrayList<>();
        longestPath(root, root, h, a);
        return toArray(a);
    }

    private boolean longestPath(BTNode head, BTNode root, int h, ArrayList<Integer> a) {
        if (root == null) {
            if (a.size() == h) return true;
            else {
                a.clear();
                return false;
            }
        }
        a.add(root.getData());
        return longestPath(head, root.getLeft(), h, a) || longestPath(head, root.getRight(), h, a);
    }

    private int[] toArray(ArrayList<Integer> a) {
        int b[] = new int[a.size()];
        for (int i = 0; i < b.length; i++)
            b[i] = a.get(i);
        return b;
    }

    /* print tree version 2 */
    public void printTree() {
        System.out.println("================================");
        showRec(root, 0);
        System.out.println("================================");
    }

    private void showRec(BTNode current, int level) {
        if (current == null)
            return;
        showRec(current.getRight(), level + 1);
        printNode(current, level);
        showRec(current.getLeft(), level + 1);
    }

    private void printNode(BTNode current, int level) {
        for (int i = 0; i < level; i++)
            System.out.print("        ");

        System.out.println("[" + current.getData() + "]");
    }

    /* check if a tree is a lightning-tree */
    public boolean isLightning() {
        return isLightning(root);
    }

    private boolean isLightning(BTNode root) {
        if (root.getLeft() == null || root.getRight() == null) {
            if (root.getLeft() == null && root.getRight() == null) return true;
            return false;
        }
        int t = Math.abs(root.getLeft().getData() - root.getRight().getData());
        return isLightning(root.getRight()) && isLightning(root.getLeft()) && (t <= 2);
    }

    /* Checks if all parents have exacly two children */
    public boolean zeroOrTwoChildes() {
        return zeroOrTwoChildes(root);
    }

    private boolean zeroOrTwoChildes(BTNode root) {
        if (root == null) return true;
        if ((root.getLeft() == null) != (root.getRight() == null)) return false;
        return zeroOrTwoChildes(root.getLeft()) && zeroOrTwoChildes(root.getRight());
    }

    /* Checks if the tree has a symmetric structure */
    public boolean isSymmetricStruct() {
        return isSymmetricStruct(root);
    }

    private boolean isSymmetricStruct(BTNode root) {
        if (root == null) return true;
        if ((root.getLeft() == null) != (root.getRight() == null)) return false;
        return isSymmetricStruct(root.getLeft()) || isSymmetricStruct(root.getRight());
    }


}
