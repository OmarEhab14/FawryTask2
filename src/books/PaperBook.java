package books;

import interfaces.Sellable;

public class PaperBook extends Book implements Sellable {
    private int stock;
    public PaperBook(String ISBN, String title, int publishYear, double price, int stock) {
        super(ISBN, title, publishYear, price);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void reduceQuantity(int quantity) {
        if (quantity > stock) {
            throw new RuntimeException("No enough quantity available");
        }
        stock -= quantity;
    }
}
