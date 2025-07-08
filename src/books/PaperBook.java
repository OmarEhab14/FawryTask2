package books;

import interfaces.Sellable;
import interfaces.Shippable;
import services.ShippingService;

public class PaperBook extends Book implements Sellable, Shippable {
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

    @Override
    public void processPayment(int quantity, String email, String address) {
        reduceQuantity(quantity);
        ship(address);
    }

    @Override
    public void ship(String address) {
        ShippingService.ship(address);
    }
}
