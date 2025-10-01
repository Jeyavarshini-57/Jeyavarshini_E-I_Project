package ebook;

public class HistoryEBook extends EBook {

    public HistoryEBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public void showDetails() {
        System.out.println("History E-Book:");
        System.out.println("Title: " + title + ", Author: " + author + ", Price: $" + price);
    }
}
