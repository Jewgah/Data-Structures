
/******************************************************************************
 *  @author Jordan Perez
 *  https://github.com/Jewgah
 *  Data Structures 2020 - CS Ariel university
 *  Assignment 2
 ******************************************************************************/

public class Range {

    public static void main(String[] args) {

        int[] arr = {1,4,1,2,7,5,2};

        Range test = new Range(arr,9);

        test.printarr();
        test.printindex();
        test.printindexsum();

        System.out.println("Numbers between 3 and 8:");
        System.out.println(test.query(3,8));
    }

    private int[] arr;
    private int k;
    private int[] index;
    private int[] indexsum;


    //Constructor
    public Range(int[] a, int k){

        this.arr=a;
        this.k=k;
        this.index = new int[k+1];
        this.indexsum = new int[k+1];

        //initialize index array to zero
        for (int i = 0; i < index.length; i++) {
            index[i]=0;
        }

        //Filling the index array
        for (int i = 0; i < arr.length; i++) {
            ++index[arr[i]];
        }

        //Building the indexsum array
        this.indexsum[0]=this.index[0];
        for (int i = 1; i < indexsum.length ; i++) {
            this.indexsum[i] = this.indexsum[i-1]+this.index[i];
        }
    }

    void printarr()
    {
        System.out.println("arr[] :");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    void printindex()
    {
        System.out.println("index[] :");
        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i]+" ");
        }
        System.out.println();
    }

    void printindexsum()
    {
        System.out.println("indexsum[] :");
        for (int i = 0; i < indexsum.length; i++) {
            System.out.print(indexsum[i]+" ");
        }
        System.out.println();
    }

    public int query(int a, int b){
        return this.indexsum[b]-this.indexsum[a]+this.index[a];
    }

}
