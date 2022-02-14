public class Book {
    private String title;
    private String author;
    private long isbn;
    private int pages;
    private int copiesInCollection;
    private int CopiesOnLoan;

    //1, complete this class with a constructor that has arguments for all the properties
    //and, getters and setters for each of them
    public Book(String title, String author, long isbn, int pages, int copiesInCollection, int copiesOnLoan) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.copiesInCollection = copiesInCollection;
        CopiesOnLoan = copiesOnLoan;
    }

    @Override
    public String toString() {
        return "\n" +
                "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn=" + isbn +
                ", pages=" + pages +
                ", copiesInCollection=" + copiesInCollection +
                ", CopiesOnLoan=" + CopiesOnLoan +
                '}';
    }

    //Creating getters and setters
    //Getters and Setters for Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //Getters and Setters for Author
    public String getAuthor() {
        return "\n" + author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    //Getters and Setters for ISBN
    public long getIsbn() {
        return isbn;
    }
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    //Getters and Setters for Pages
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }

    //Getters and Setters for copiesInCollection
    public int getCopiesInCollection() {
        return copiesInCollection;
    }
    public void setCopiesInCollection(int copiesInCollection) {
        this.copiesInCollection = copiesInCollection;
    }

    //Getters and Setters for copiesOnLoan
    public int getCopiesOnLoan() {
        return CopiesOnLoan;
    }
    public void setCopiesOnLoan(int copiesOnLoan) {
        CopiesOnLoan = copiesOnLoan;
    }
}
