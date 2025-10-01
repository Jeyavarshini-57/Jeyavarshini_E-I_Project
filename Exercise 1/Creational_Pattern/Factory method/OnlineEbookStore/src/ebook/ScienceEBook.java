package ebook;

public class ScienceEBook extends EBook {

    public ScienceEBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public void showDetails() {
        System.out.println("Science E-Book:");
        System.out.println("Title: " + title + ", Author: " + author + ", Price: $" + price);
    }
}
