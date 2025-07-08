package books;

import interfaces.Sellable;

public class EBook extends Book implements Sellable {
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
}
