package interfaces;

public interface Sellable {
    void processPayment(int quantity, String email, String address);
}