import java.util.Arrays;

public class mergeSort {
    //Merges two arrays
    public static int[] merge(int[] arr, int low, int mid, int high){
        //Sizes of both the arrays
        int n1= mid-low+1;
        int n2=high-mid;

        //Creating temporary arrays
        int[] tempArray1 = new int[n1];
        int[] tempArray2 = new int[n2];

        //Loops to put data into tempArrays
        for(int i = 0; i<n1; i++){
            tempArray1[i] = arr[low + i];
        }
        for(int i = 0; i<n2; i++){
            tempArray2[i] = arr[mid+1+i];
        }

        //Now, merging these arrays
        // Initial indices of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array
        int k = low;
        while (i < n1 && j < n2) {
            if (tempArray1[i] <= tempArray2[j]) {
                arr[k] = tempArray1[i];
                i++;
            } else {
                arr[k] = tempArray2[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of both arrays
        while (i < n1) {
            arr[k] = tempArray1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = tempArray2[j];
            j++;
            k++;
        }
        return arr;
    }

    //Main Recursive part of mergesort
    //Merge Sort keeps on dividing an array until there is only one element left after which
    //it compares, puts the element in the right spot, and merges.
    //Merge Sort's best case: nlogn, Avg. Case: nlogn, Worst case: nlogn
    public static int[] mergeSort(int[] arr, int low, int high){
        if(low<high){
            int mid = low+(high-low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {7,5,3,1,32,17,2};
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length-1)));
    }
}
