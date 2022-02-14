import java.util.Arrays;

public class BookMain {
    public static void main(String[] args) {
        BookCollection bCollection = new BookCollection("BookList.csv");
        System.out.println(Arrays.toString(bCollection.mostPopular()));
    }
}
