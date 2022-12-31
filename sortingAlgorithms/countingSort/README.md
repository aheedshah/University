Counting Sort is the best algorithms to use when you have **small positive integers** with a linear time complexity of O(n+k) under all circumstances. 
Here, k stands for the range of input (max element's in the array - min number in the array)
It is also a stable algorithm an algorithm which sorts without comparing integers. 

They way this algorithm works is by counting the number of occurrences of each unique element in the array. 
The count is stored in an temporary array and the sorting is done by mapping the count as an index of the temporary array.

Example Working:
Sorting this Array: {2, 1, 4, 2, 5, 3, 2, 10, 1}
Creating a temp array with length = array.length+1

Temp array stores occurences of each element in the array: {0, 2, 3, 1, 1, 1, 0, 0, 0, 1}
Here, index 0 stores 0 as there are no 0's in the given array. Index 1 stores 2 as the number 2 is 2 times in the given array and so on.

Now, the original array is sorted according to the count of the numbers in the temporary array.
