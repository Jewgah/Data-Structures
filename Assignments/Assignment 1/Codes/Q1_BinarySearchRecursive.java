/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Recursive Binary Search Algorithm Implementation
 ******************************************************************************/

public class Q1_BinarySearchRecursive {

    //for decreasing arr
    //Complexity of O(logn)
    public static void main(String[] args) {
            int[] arr = {8,7,6,5,4,3,2,1};
            int key = 3;
            int result =  binarySearch(arr,key);

            System.out.println(result != -1  ? "Found at index " +result : "Not Found");
    }

    public static int binarySearch(int[] arr, int key){

        // array is sorted from biggest to smallest:
        if(key > arr[0] || key < arr[arr.length-1]) return -1;

        return binarySearchRecursive(arr,0,arr.length-1,key);
    }

    public static int binarySearchRecursive(int[] arr, int low, int high, int key){

        if(low<=high) {
            int mid = (low + high) / 2;
            if (key == arr[mid])return mid;
            else if (key < arr[mid]) return  binarySearchRecursive(arr, mid + 1, high, key);
            else return binarySearchRecursive(arr, low, mid - 1, key);
        }

        else return -1;
        }
    }

