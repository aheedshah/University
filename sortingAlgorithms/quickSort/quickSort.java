import java.util.Arrays;

public class quickSort {
    //Swaps elements at i and j index of an array
    public static int[] swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    //Does 3 tasks for quick sort.
    //1. Selects a pivot,
    //2. Move numbers lower than pivot to the left part of the array
    //3. Moves pivot to its final position
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high]; //Element at highest index is the pivot we choose
        int i = low-1; //Index of the smallest element.

        //Looping from lowest to the highest index
        for(int j = low; j<= high-1; j++){
            //If element at j is smaller than pivot,
            if(arr[j]<pivot){
                i++; //Increment i by 1
                swap(arr, i, j); //And swap the positions
            }
        }
        swap(arr, i+1, high);
        return ++i;
    }

    //Main part for quicksort. There are many ways to do it but I have used the recursive way.
    //The way quicksort works is by choosing a pivot and storing every number greater than the pivot
    //on the right of the array and every number lesser than it on the left hand side.
    //It's a pretty good algorithm with best case of: n(logn) Avg Case of: nlogn and Worst case of: O(N^2)
    public static int[] quickSort(int[] arr, int low, int high){
        if(low<high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
        return arr;
    }

    public static void main(String[] args) {
        //Test
        int[] arr = {3, 45, 21, 73, 59, 23, 18};
        System.out.println(Arrays.toString(quickSort(arr, 0, 6)));
    }
}
