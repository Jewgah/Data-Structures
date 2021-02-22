/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Binary Search Algorithm Implementation
 ******************************************************************************/

public class BinarySearchBetween {

    //for increasing arr
    //Complexity of O(nlogn)
    /**
     * if value < arr[0] return 0
     * if value > arr[end] return end+1
     * if arr[index-1] < value <= arr[index] return index
     */

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};
        int key = 6;
        int result =  binarySearchBetween(arr,key);

        System.out.println(result != -1  ? "Found at index " +result : "Not Found");
    }

    public static int binarySearchBetween(int arr[], int value){

        int low = 0, end = arr.length-1, high = end;

        if(value < arr[0]) return 0;
        if(value>arr[end]) return end+1;

        while(low <= high) {
            int middle = (low + high) / 2;

            if (low == high) return low;
            else {
                if (arr[middle] == value) return middle;
                if (value < arr[middle]) high = middle;
                else low = middle + 1;
            }
        }
        return 1;
    }
}
