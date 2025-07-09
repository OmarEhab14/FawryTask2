package test;

import books.ShowcaseBook;
import books.EBook;
import books.PaperBook;
import core.Inventory;

public class BookstoreTestCases {
    Inventory inventory;

    public BookstoreTestCases() {
        inventory = new Inventory();
    }

    public void testAddBooks() {
        System.out.println("\n--- Test: Add Books ---");
        PaperBook paperBook = new PaperBook("ISBN-123", "Clean Code", 2018, 300.0, 5);
        EBook eBook = new EBook("ISBN-456", "AI with Java", 2022, 150.0, "PDF");
        ShowcaseBook showcaseBook = new ShowcaseBook("ISBN-789", "Showcase book", 2000, 0.0);

        inventory.addBook(paperBook);
        inventory.addBook(eBook);
        inventory.addBook(showcaseBook);
    }

    public void testPrintInventory() {
        System.out.println("\n--- Test: Print Inventory ---");
        inventory.printInventory();
    }

    public void testBuyPaperBook() {
        System.out.println("\n--- Test: Buy PaperBook ---");
        try {
            double total = inventory.buy("ISBN-123", 2, "user@example.com", "Cairo");
            System.out.println("Paid: $" + total);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void testBuyEBook() {
        System.out.println("\n--- Test: Buy EBook ---");
        try {
            double total = inventory.buy("ISBN-456", 1, "user@example.com", null);
            System.out.println("Paid: $" + total);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void testBuyShowcaseBook() {
        System.out.println("\n--- Test: Buy ShowcaseBook (should fail) ---");
        try {
            inventory.buy("ISBN-789", 1, "user@example.com", null);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }

    public void testBuyNonExistentBook() {
        System.out.println("\n--- Test: Buy Non-Existent Book (should fail) ---");
        try {
            inventory.buy("ISBN-000", 1, "user@example.com", null);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }

    public void testBuyWithInsufficientStock() {
        System.out.println("\n--- Test: Buy More Than Available Stock (should fail) ---");
        try {
            inventory.buy("ISBN-123", 10, "user@example.com", "Giza");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }

    public void testRemoveOutdatedBooks() {
        System.out.println("\n--- Test: Remove Outdated Books (>10 years old) ---");
        var removed = inventory.removeOutdatedBooks(10);
        for (var book : removed.values()) {
            System.out.println("Removed: " + book.getTitle() + " (" + book.getPublishYear() + ")");
        }
    }
}
