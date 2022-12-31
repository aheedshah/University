import java.util.Arrays;

public class bubbleSort {
    //Code for swapping array's indices
    public static int[] swap(int arr[], int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
        return arr;
    }
    //Code for Bubble Sort
    public static int[] bubbleSort(int arr[]){
        int n = arr.length;
        boolean swapped = true;
        while (swapped){
            swapped = false;
            for(int i = 0; i<n-1; i++){
                if(arr[i]>arr[i+1]){
                    swap(arr, i, i+1);
                    swapped = true;
                }
            }
            n--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
