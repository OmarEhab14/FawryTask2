import test.BookstoreTestCases;

public class Main {
    public static void main(String[] args) {
        BookstoreTestCases tester = new BookstoreTestCases();

        tester.testAddBooks();
        tester.testPrintInventory();
        tester.testBuyPaperBook();
        tester.testBuyEBook();
        tester.testBuyShowcaseBook();
        tester.testBuyNonExistentBook();
        tester.testBuyWithInsufficientStock();
        tester.testRemoveOutdatedBooks();
        tester.testPrintInventory();
    }
}