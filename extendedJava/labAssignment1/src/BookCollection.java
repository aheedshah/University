import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class BookCollection implements Comparator<Book>{
    private ArrayList<Book> books= new ArrayList<>();
    @Override
    public int compare(Book o1, Book o2) {
        if(o1.getCopiesOnLoan()<o2.getCopiesOnLoan()){
            return 1;
        } else if(o1.getCopiesOnLoan()>o2.getCopiesOnLoan()){
            return -1;
        }
        return 0;
    }

    //2, complete constructor that takes a string path (the BookList file name) load the books from BookList into the books arrayList
    //When complete books should have 100 items. Make sure you don't include the header row!
    BookCollection(String path){
        try {
            //Using the scanner to get the file
            Scanner sc = new Scanner(new File(path));
            //Using an array to store the headers
            String[] header = sc.nextLine().split(",");
            //Now, we loop till the file's next line is empty
            while(sc.hasNextLine()){
                String[] nextRow = sc.nextLine().split(",");
                Book thisBook = new Book(nextRow[0], nextRow[1], Long.parseLong(nextRow[2]), Integer.parseInt(nextRow[3]), Integer.parseInt(nextRow[4]),Integer.parseInt(nextRow[5]));
                books.add(thisBook);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File wasn't found!");
        }

    }

//    3, Return a HashSet of all the authors in the book list
    public HashSet<String> getAuthors(){
        HashSet<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        System.out.println("There are " + authors.size() + " authors in the file provided without any duplicates. List of all authors is given below:");
        return authors;
    }

//    4, return an arrayList of books with more than 750 pages
    public ArrayList<Book> getLongBooks(){
        ArrayList<Book> longBooks = new ArrayList<>();
        for (Book book: books) {
            if(book.getPages()>750){
                longBooks.add(book);
            }
        }
        System.out.println("There are " + longBooks.size() + " books with pages greater than 750. Their details are as follows:");
        return longBooks;
    }

//    5, return the book if the given title is in the list.
    public Book getBookByTitle(String title){
        for (Book book: books) {
            if(book.getTitle().equals(title)){
                System.out.println("Your book Details are as follows:");
                return book;
            }
        }
        System.out.println("Your book wasn't found!");
        return null;
    }

//    6, return an array of the 10 most popular books (That is those that currently have most copies on loan)
    public Book[] mostPopular(){
        Book[] arr = new Book[10];
        //Sorting the arraylist in descending order on the basis of copies on loan and then just adding 'em to arr
        books.sort(this);
        for(int i = 0; i<10; i++){
            arr[i] = books.get(i);
        }
        System.out.println("List of the top 10 most popular books in the given file:");
        return arr;
    }
}