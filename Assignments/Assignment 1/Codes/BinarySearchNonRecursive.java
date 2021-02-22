/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Non-Recursive Binary Search Algorithm Implementation
 ******************************************************************************/

public class BinarySearchNonRecursive {

    //for decreasing arr
    //Complexity of O(logn)
    public static void main(String[] args) {

        int[] arr = {1,1,1,2,2,2,3,4};
        int key = 1;
        int result =  binarySearchNormal(arr,key);

        System.out.println(result != -1  ? "Found at index " +result : "Not Found");
    }

    public static int binarySearchNormal(int[] arr, int value){

        // array is sorted from smallest to biggest:
        if(value < arr[0] || value > arr[arr.length-1]) return -1;

            int low = 0, high = arr.length-1;

            while(low <= high){

                int middle = (low+high)/2;

                if(arr[middle]==value){
                    return middle;
                }
                if(value<arr[middle]){
                    high = middle-1;
                }
                else{
                    low = middle+1;
                }
            }
            return -1;
    }
}
