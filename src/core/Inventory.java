package core;

import books.Book;
import books.EBook;
import books.PaperBook;
import interfaces.Sellable;
import services.MailingService;
import services.ShippingService;

import java.time.Year;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Inventory {
    private Map<String, Book> books;
    public Inventory() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public Map<String, Book> removeOutdatedBooks(int requiredYearsPassed) {
        Map<String, Book> outdatedBooks = new HashMap<>();
        int currentYear = Year.now().getValue();

        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            if (currentYear - entry.getValue().getPublishYear() > requiredYearsPassed) {
                outdatedBooks.put(entry.getKey(), entry.getValue());
                iterator.remove();
            }
        }

        return outdatedBooks;
    }


    public double buy(String ISBN, int quantity, String email, String address) {
        Book book = books.get(ISBN);
        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        if (!(book instanceof Sellable)) {
            throw new RuntimeException("This book is not for sale");
        }
        if (book instanceof PaperBook) {
            ((PaperBook) book).reduceQuantity(quantity);
            ShippingService.ship(address);
        } else if (book instanceof EBook) {
            MailingService.sendMail(email);
        }
        return quantity * book.getPrice();
    }

    public void printInventory() {
        System.out.println("Inventory List: ");

        if (books.isEmpty()) {
            System.out.println("No books in inventory.");
            return;
        }

        for (Book book : books.values()) {
            System.out.println("-----------------------------------");
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Year: " + book.getPublishYear());
            System.out.println("Price: $" + book.getPrice());

            if (book instanceof PaperBook paper) {
                System.out.println("Type: Paper Book");
                System.out.println("Stock: " + paper.getStock());
            } else if (book instanceof EBook ebook) {
                System.out.println("Type: EBook");
                System.out.println("File Type: " + ebook.getFileType());
            } else {
                System.out.println("Type: Showcase Book");
            }
        }
        System.out.println("-----------------------------------");
    }


    public Map<String, Book> getBooks() {
        return books;
    }
}
