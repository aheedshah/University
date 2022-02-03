import java.util.Arrays;

public class HashTable {
    private int[] buckets;
    public long a; //The constant for the equation
    public long c; //Another constant for the equation
    public int m; //Number of buckets of the hashtable.

    /**
     * This constructor function initialises the values of a, c and m
     * and allocates memory for m buckets. It also fills buckets with -1.
    */
    public HashTable(long _a, long _c, long _m) {
        //Initialising the variables
        a = _a;
        c = _c;
        //Parsing into int because array don't accept long variables
        m = (int) _m;
        //Allocating memory for m int values
        buckets = new int[m];
        System.out.println("Number of buckets provided at start = " + m);
        //Filling the entire array with -1 to see what indices are empty
        Arrays.fill(buckets, -1);
    }

    /**
     * This function takes an argument of key and inserts it into the
     * buckets array. It uses linear probing as the collision resolution method
    */
    public void insert(int key) {
        //Checks if the load factor is >1. If it is, then we extend the array to twice it's size using extend()
        if(loadFactor()>=1) {
            extend();
        }

        //Finding the index at which key will be inserted
        int insertAtIndex = (int)((a*key+c)% buckets.length); //This is the equation for the hash table

        //Looping from insertAtIndex to buckets.length to find
        //an empty spot to fill the key
        for(int i = insertAtIndex; i<buckets.length; i++){
            //If the index is empty, then insert the key
            if (buckets[insertAtIndex] == -1) {
                buckets[insertAtIndex] = key;
                System.out.println("Inserted the key: " + key + " at index = " + insertAtIndex);
                break;
            }
            //otherwise, try the next index
            insertAtIndex++;
        }
    }

    /**
     * This function extends the array to twice its original size
     * and temporarily creates an array to store the previous elements
    */
    public void extend(){
        //Creating a new array of the length of buckets to
        // store the elements in buckets
        int[] newBucket = new int[buckets.length];
        //Putting all elements of buckets into newBuckets
        System.arraycopy(buckets, 0, newBucket, 0, newBucket.length);
        //Extending the buckets' length to twice the length
        buckets = new int[2*newBucket.length];
        System.out.println("Array is now extended to store twice the amount of buckets. It can now store " + buckets.length + " number of elements");
        //Filling the whole new bucket with -1 to make it empty according to our class
        Arrays.fill(buckets,-1);
        //Adding the old elements back into the extended array
        System.arraycopy(newBucket, 0, buckets, 0, newBucket.length);
    }

    /**
     * This function returns true if key is found and false otherwise
    */
    public boolean find(int key) {
        int index = (int) ((a*key+c)%m); //This is the equation for the hash table
        if(buckets[index] == key){
            System.out.println("Found the key: " + key + " at index = " + index);
            return true;
        } else{ //Remember, due to linear probing, the key might not be always at it's desired index. So, if the key isn't found there, we need to loop till the end of the array to find it.
            for(int i = index; i< buckets.length; i++){
                if(buckets[i] == key){ //If it is found between i=index and i=buckets.length-1, we return true.
                    System.out.println("Found the key: " + key + " at index = " + i);
                    return true;
                }
            }
        }
        return false; //Else, we return false
    }

    /**
     * This function removes the key from the array
    */
    public void remove(int key) {
        int index = (int) ((a*key+c)%m); //This is the equation I'm using for my hash table. You can change it according to your hash table needs.
        //This uses the same reasoning as given in the find() function above. If the key is found there, we remove it by making it equal to -1
        if(buckets[index] == key){
            System.out.println("Removed the key " + key + " at the index = " + index);
            buckets[index] = -1;
        } else{
            for(int i = index; i<buckets.length; i++){
                if (buckets[i] == key) {
                    System.out.println("Removed the key " + key + " at the index = " + i);
                    buckets[index] = -1;
                    break;
                }
            }
        }
    }

    /**
     * This function returns the loadFactor of the bucket array
    */
    public double loadFactor() {
        double count = 0; //This variable keeps count of the number of buckets which are currently being used.
        for (int bucket : buckets) {
            if (bucket != -1) {
                count++; //The number of elements in the array which are not equal to -1 are being used. So, we increase count by 1 each time.
            }
        }
        System.out.println("Current Load Factor = " + (count/buckets.length));
        return (count/buckets.length); //And, we return the load factor which is: (no. of elements being used)/(total array length)
    }

    public static void main(String[] args) {
        //This is just an implementation to show you how this works.
        //Creating a new hashTable
        HashTable hello = new HashTable(25,37,257);
        for(int i = 0; i<300; i++){
            hello.insert(i);
            hello.find(i);
        }

        //You can try removing, finding, inserting here as well by uncommenting these:
//        hello.remove(231);
//        hello.find(178);
//        hello.insert(232);

    }
}
