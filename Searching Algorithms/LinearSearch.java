package Sorts;

import java.util.Arrays;

/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Searching Algorithms
 *  Linear Search implementation
 ******************************************************************************/

public class LinearSearch {

    public static int search(int[] arr, int x) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 4, 10, 40};
        int x = 10;
        System.out.println(Arrays.toString(arr));

        int result = search(arr, x);

        if (result == -1)
            System.out.println("not presented");
        else
            System.out.println("the element presened at index: " + result);
    }
}
