package ebook;

public class FictionEBook extends EBook {

    public FictionEBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public void showDetails() {
        System.out.println("Fiction E-Book:");
        System.out.println("Title: " + title + ", Author: " + author + ", Price: $" + price);
    }
}
