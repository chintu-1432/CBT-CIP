public class Book {
    private final String title;
    private final String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title.trim();
        this.author = author.trim();
        this.isbn = isbn.trim();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void showDetails() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("ISBN   : " + isbn);
        System.out.println("----------------------------");
    }

    public String toFileString() {
        return title + "," + author + "," + isbn;
    }

    public static Book fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 3) {
            return new Book(parts[0], parts[1], parts[2]);
        }
        return null;
    }
}