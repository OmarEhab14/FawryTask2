import test.QuantumBookstoreTestCases;

public class Main {
    public static void main(String[] args) {
        QuantumBookstoreTestCases tester = new QuantumBookstoreTestCases();

        tester.testAddBooks();
        tester.testPrintInventory();
        tester.testBuyPaperBook();
        tester.testBuyEBook();
        tester.testBuyDemoBook();
        tester.testBuyNonExistentBook();
        tester.testBuyWithInsufficientStock();
        tester.testRemoveOutdatedBooks();
        tester.testPrintInventory();
    }
}