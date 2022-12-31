import java.util.Arrays;

//Insertion sort: The array is virtually split into a sorted and an unsorted part.
//Values from the unsorted part are picked and placed at the correct position in the sorted part.
//Worst Case: O(n^2). Avg case: O(n^2). Best Case: O(n)
public class insertionSort {
    public static int[] insertionSort(int[] arr){
        for(int i = 1; i<arr.length; i++){
            int ins = arr[i];
            int j = i-1;
            while (j>=0 && ins<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = ins;
        }
        return arr;
    }

    public static void main(String[] args) {
        //Testing my code
        int[] arr = {2,5,3,1,7};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }
}
