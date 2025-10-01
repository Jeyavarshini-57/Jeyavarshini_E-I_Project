package ebook;

public abstract class EBook {
    protected String title;
    protected String author;
    protected double price;

    public EBook(String title, String author, double price) {
        if (title == null || author == null || price < 0)
            throw new IllegalArgumentException("Invalid parameters for EBook.");
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public abstract void showDetails();
}
