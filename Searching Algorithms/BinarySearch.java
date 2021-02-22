
package Sorts;

import java.util.Arrays;

/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Searching Algorithms
 *  Binary Search implementation
 ******************************************************************************/

public class BinarySearch {

    public static int binarySearch(int arr[], int left, int right, int x) {

        if (right >= 1) {

            int middle = left + (right - left) / 2; // the main concept step

            if (arr[middle] == x)
                return middle;

            if (arr[middle] > x)
                return binarySearch(arr, left, middle - 1, x);

            else
                return binarySearch(arr, middle + 1, right, x);
        }
        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        System.out.println(Arrays.toString(arr));

        int result = binarySearch(arr, 0, n - 1, x);

        if (result == -1)
            System.out.println("the element isn't presented in the array");
        else
            System.out.println("The element is persented at index: " + result);
    }
}
