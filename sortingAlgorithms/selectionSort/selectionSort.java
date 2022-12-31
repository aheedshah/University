import java.util.Arrays;

public class selectionSort {
    //Code for swapping array's indices
    public static int[] swap(int arr[], int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
        return arr;
    }

    //Finds the minimum index of an array between a and b
    public static int minimumIndex(int[] arr, int a, int b){
        int min = arr[a];
        int index = a;
        for(int i = a; i<= b; i++){
            if(min>arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    //Code for Selection Sort
    public static int[] selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            int min = minimumIndex(arr, i, n-1);
            swap(arr, i, min);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,3,9,4};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
}
