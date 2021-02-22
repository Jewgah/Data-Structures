
/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Assignment 1
 ******************************************************************************/

public class Ex1 {

    public static void main(String[] args) {

        int[] arr = new int[200];
        int i=0;
        for(i=0; i<200; i++){
            arr[i]=i;
        }
        int key = 199;
        int result = Search(arr,key);
        System.out.println(result != -1  ? "Found at index " +result : "Not Found");
    }


    public static int Search(int[] arr, int k){

        if(k< arr[0] || k>arr[arr.length-1]) return -1;
        if(k == arr[0]) return 0;

        double i=0;
        double low = 0, high = arr.length-1;

        //set low
        while(Math.pow(2.0,i) < arr.length-1 && arr[(int)Math.pow(2.0,i)] < k){
            low = Math.pow(2.0,i);
           // System.out.println("i= "+i+": arr[2^i]= arr[2^"+i+"]= arr["+low+"]= "+arr[(int)low]);
           // System.out.println(+arr[(int)low]+"<k (k="+k+") so i++\n");
            i++;
        }
        //System.out.println("so low is set at: "+low);

        //set high
        if(Math.pow(2.0,i+1) > arr.length-1) high = arr.length-1;
        else high = arr[(int)Math.pow(2.0,i+1)];

        //System.out.println("and high is set at: "+high);

        //System.out.println("we apply a binarysearch between low and high:");
        //binarySearch
        while(low <= high){

            int middle = (int)(low+high)/2;

            if(arr[middle]==k){
                return middle;
            }
            if(k<arr[middle]){
                high = middle-1;
            }
            else{
                low = middle+1;
            }
        }

        return -1;
    }
}
