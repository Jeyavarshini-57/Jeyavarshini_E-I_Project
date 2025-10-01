package ebook;

public class EBookFactory {

    public static EBook createEBook(String type, String title, String author, double price) {
        if (type == null || title == null || author == null)
            throw new IllegalArgumentException("Type, title or author cannot be null.");

        return switch (type.toLowerCase()) {
            case "fiction" -> new FictionEBook(title, author, price);
            case "science" -> new ScienceEBook(title, author, price);
            case "history" -> new HistoryEBook(title, author, price);
            default -> throw new IllegalArgumentException("Unknown EBook type: " + type);
        };
    }
}
