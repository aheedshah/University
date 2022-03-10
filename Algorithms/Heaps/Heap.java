import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Heap {
    // public for JUnit testing purposes
    public ArrayList<Integer> array = new ArrayList<>();
    public int heap_size;

    public Heap(int size) {
        array = new ArrayList<>(size);
        heap_size = size;
    }

    public Heap(List<Integer> source) {
        this(source, false);
    }

    public Heap(List<Integer> source, boolean incremental) {
        if(incremental){
            for(int i = 0; i<source.size(); i++){
                System.out.println("Input array: " + source + " and incremental is true");
                insert(source.get(i));
            }
        } else {
            System.out.println("Input array: " + source + " and incremental is false");
            array.addAll(source);
            heap_size = source.size();
            buildMaxHeap();
        }
    }

    public static int parent(int index) {
        return ((index-1)/2);
    }
    public static int left(int index) {
        return ((2*index)+1);
    }
    public static int right(int index) {
        return (2*(index+1));
    }

    public void maxHeapify(int i) {
        int largest = i;
        int left = left(i);
        int right = right(i);
        if(left<array.size() && array.get(left)>array.get(largest)) {
            largest = left;
        }
        if(right<array.size() && array.get(right)>array.get(largest)){
            largest = right;
        }
        if(largest != i){
            int swap = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, swap);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        for(int i =(heap_size / 2) - 1; i>=0; i--){
            maxHeapify(i);
        }
    }

    public void insert(Integer k) {
        int pos = heap_size;
        array.add(k);
        heap_size++;
        while (pos>0 && array.get(parent(pos))<array.get(pos)){
            Collections.swap(array, parent(pos), pos);
            pos=parent(pos);
        }
    }

    public Integer maximum() {
        return array.get(0);
    }
    public Integer extractMax() {
        int max = Collections.max(array);
        array.set(0, array.get(array.size()-1));
        array.remove(array.size()-1);
        heap_size--;
        maxHeapify(0);
        return max;
    }

    public ArrayList<Integer> sort(){
        ArrayList<Integer> ar = (ArrayList<Integer>)array.clone();
        Collections.sort(ar);
        return ar;
    }
}
