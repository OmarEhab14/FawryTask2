package books;

import interfaces.Emailable;
import interfaces.Sellable;
import services.MailingService;

public class EBook extends Book implements Sellable, Emailable {
    private String fileType;

    public EBook(String ISBN, String title, int publishYear, double price, String fileType) {
        super(ISBN, title, publishYear, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public void sendEmail(String email) {
        MailingService.sendMail(email);
    }

    @Override
    public void processPayment(int quantity, String email, String address) {
        sendEmail(email);
    }
}
