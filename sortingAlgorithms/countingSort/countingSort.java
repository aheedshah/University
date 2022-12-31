import java.util.Arrays;

public class countingSort {
    public static int[] countingSort(int[] arr) {
        int n = arr.length;
        if(n==0){
            return arr;
        }

        //Finding the minimum and maximum values in the array
        int min = minimumValue(arr);
        int max = maximumValue(arr);

        int range = max-min+1; //Used to create the length of a new array below

        int[] tempArray = new int[range]; //Length of range for the temp array

        //Initialising the occurrence of each element in the tempArray using foreach loop
        for (int i : arr) {
            tempArray[i - min]++;
        }
        //Adding the sum of indices and storing them in tempArray
        for(int i = 1; i<range; i++){
            tempArray[i]+=tempArray[i-1];
        }
        //Sorting the original array according to the count of numbers in the count in the tempArray
        int j = 0;
        for(int i = 0; i<range; i++){
            while(j<tempArray[i]){
                arr[j++] = i+min;
            }
        }
        return arr;
    }

    //Finds the min value in an array
    public static int minimumValue(int[] arr){
        int min = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    //Finds the max value in an array
    public static int maximumValue(int[] arr){
        int max = arr[0];
        for(int i = 1; i<arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingSort(new int[]{2, 1, 4, 2, 5, 3, 2, 10, 1})));
    }
}
