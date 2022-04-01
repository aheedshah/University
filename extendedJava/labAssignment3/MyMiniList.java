import java.util.ArrayList;

public class MyMiniList <T> implements MiniList<T> {
    T[] arr;
    int size;

    /**
     * Constructor function to initialise the array of elements
     * This function also sets the size variable to be equal to 0.*/
    public MyMiniList(){
        arr = (T[]) new Object[10];
        size = 0;
    }

    /**
     * This method adds the elements to the array. It doubles the
     * size of the array if there is no space left for the new element.
     * @param element The element to be added to the arraylist*/
    @Override
    public void add(T element) {
        //If the array has no space left, we double its length
        if(size>=arr.length){
            //Cloning arr to a new temporary array to store the elements
            T[] tempArr = arr.clone();
            //Doubling the size of arr
            arr = (T[]) new Object[2*tempArr.length];
            //Copying all the elements stores in tempArr to the new array
            System.arraycopy(tempArr, 0, arr, 0, tempArr.length);
        }
        //Finally, we just add the element at the end of the array
        arr[size] = element;
        //And we increase size by 1
        size++;
    }

    /**
     * This method returns the item at the index provided.
     * @param index The index where the element is to be found
     * @return The element at index
     * */
    @Override
    public T get(int index) {
        //If the index is not within the bounds, we return null
        if(isNotValid(index)){
            return null;
        }
        //Else, we return the element at index
        return arr[index];
    }

    /**
     * Finds the index of element provided
     * @param element The element whose index we have to find
     * @return The index of element*/
    @Override
    public int getIndex(T element) {
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == element){
                return i;
            }
        }
        return -1;
    }

    /**
     *  Sets the value at index to be equal to element
     * @param index The index where element is to be set
     * @param element The element to be set at index
     * */
    @Override
    public void set(int index, T element) {
        //If the index is not valid, we return
        if(isNotValid(index)){
            return;
        }
        //Else, we set the value at the index to be the element given
        arr[index] = element;
    }

    /**
     * @return size of the list*/
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes the index provided and returns it.
     * @param index The index to be removed
     * @return The element which was removed*/
    @Override
    public T remove(int index) {
        //If the index is not valid, we return null
        if(isNotValid(index)){
            return null;
        }

        //Storing the removedElement to be removed at the end
        T removedElement = arr[index];
        //We then set the element at the index as null
        arr[index] = null;

        //Creating an array to store elements temporarily
        T[] tempArray = arr.clone();

        //Creating a new arrayList and adding all elements of
        //tempArray into it except for null values
        ArrayList<Object> arrayList = new ArrayList<>();
        for (Object o: tempArray) {
            if(o!=null){
                arrayList.add(o);
            }
        }

        //Clearing the existing array and adding the values of arraylist into it
        arr = (T[]) new Object[tempArray.length-1];
        arr=arrayList.toArray((T[]) new Object[arrayList.size()]);
        //Putting all the elements into the array and reducing the size by 1
        size--;
        return removedElement;
    }

    @Override
    public boolean remove(T element) {
        //Searching for the first instance of element
        for(int i = 0; i< arr.length; i++){
            //If the element is found, we remove it and return true
            if(arr[i] == element){
                remove(i);
                return true;
            }
        }
        //Else, we return false;
        return false;
    }

    /**
     * This method empties the list and resets the size to 0*/
    @Override
    public void clear() {
        arr = (T[]) new Object[10];
        size = 0;
    }

    /**
     * This method checks if the index is valid
     * @param index The index which needs to be checked
     * @return boolean value of whether the index is valid or not*/
    public boolean isNotValid(int index){
        return index > size || index < 0;
    }
}
