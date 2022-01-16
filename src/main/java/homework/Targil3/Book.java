package homework.Targil3;

public class Book {
    private String bookName;
    private String author;
    private double price;
    private int numberOfPages;
    //private cover;

    public Book(){}

    public Book(String bookName, String author, double price, int numberOfPages) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
