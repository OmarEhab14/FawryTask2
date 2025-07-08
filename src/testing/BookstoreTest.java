package testing;

import books.DemoBook;
import books.EBook;
import books.PaperBook;
import core.Inventory;

public class BookstoreTest {
    public static void test() {
        Inventory inventory = new Inventory();

        PaperBook javaBook = new PaperBook("P123", "Learn Java", 2022, 50, 5);
        EBook pythonBook = new EBook("A456", "Learn Python", 2023, 30, "pdf");
        DemoBook demoBook = new DemoBook("D223", "Demo", 2011, 0);

        inventory.addBook(javaBook);
        inventory.addBook(pythonBook);
        inventory.addBook(demoBook);

        inventory.printInventory();
        inventory.removeOutdatedBooks(4);
        System.out.println("after removing outdated books: ");
        inventory.printInventory();

        try {
            System.out.println("Total: $" + inventory.buy("P123", 2, "omarehab@gmail.com", "Cairo"));
            System.out.println("Total: $" + inventory.buy("A456", 1, "ziadrawash@gmail.com", "Alexandria"));

            System.out.println("Total: $" + inventory.buy("S441", 2, "omarehab@gmail.com", "Cairo"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void NoEnoughStock() {

    }
}
