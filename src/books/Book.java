package books;

public class Book {
    private String ISBN;
    private String title;
    private int publishYear;
    private double price;

    public Book(String ISBN, String title, int publishYear, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishYear = publishYear;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
