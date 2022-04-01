import java.util.stream.IntStream;

public class MiniListTests {
    //add elements to the array
    public static void main(String[] args) {
        //Creating a new arraylist to store the colours.
        MyMiniList<String> ml = new MyMiniList<>();
        //Adding colours for testing
        ml.add("aliceblue");
        ml.add("antiquewhite");
        ml.add("aqua");
        ml.add("aquamarine");
        ml.add("azure");
        ml.add("beige");
        ml.add("bisque");
        ml.add("black");
        ml.add("blanchedalmond");
        ml.add("blue");
        ml.add("blueviolet");
        ml.add("brown");
        ml.add("burlywood");
        ml.add("cadetblue");
        ml.add("chartreuse");
        ml.add("chocolate");
        ml.add("coral");
        ml.add("cornflowerblue");
        ml.add("cornsilk");
        ml.add("crimson");
        ml.add("cyan");
        ml.add("darkblue");
        ml.add("darkcyan");
        ml.add("darkgoldenrod");
        ml.add("darkgray");
        ml.add("darkgreen");
        ml.add("darkgrey");
        ml.add("darkkhaki");
        ml.add("darkmagenta");
        ml.add("darkolivegreen");
        ml.add("coral");

        //Get element at index and output it
        String atIndex = ml.get(23);
        System.out.println("At the 23rd Location is: " + atIndex); //Should return darkgoldenrod

        //Get first occurrence of the element and output it
        int n = ml.getIndex("coral");
        System.out.println("coral is at: " + n); //Should return 16

        //Set value at an index
        ml.set(9, "testUpdate");
        ml.set(23, "testUpdate2");

        //Remove element by object
        ml.remove("crimson");

        //Remove element by index
        ml.remove(7);

        //Output the arraylist
        IntStream.range(0, ml.size()).mapToObj(ml::get).forEach(System.out::println);

        //clear the arraylist and output its size
        ml.clear();
        System.out.println("the size of ml after clearing it is: " + ml.size()); //Should be 0
    }
}

