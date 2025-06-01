import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCatalog {
    private final ArrayList<Book> bookList;
    private final String fileName = "books.txt";

    public LibraryCatalog() {
        bookList = new ArrayList<>();
        loadBooksFromFile();
    }

    public void addBook(Book newBook) {
        bookList.add(newBook);
        saveBookToFile(newBook);
        System.out.println(" Book successfully added!");
    }

    public void displayAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println(" No books available in the catalog.");
            return;
        }

        System.out.println("\n All Books in the Library:");
        for (Book book : bookList) {
            book.showDetails();
        }
    }

    public void findByTitle(String titleQuery) {
        boolean isFound = false;
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(titleQuery.trim())) {
                book.showDetails();
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println(" No match found for the title: " + titleQuery);
        }
    }

    public void findByAuthor(String authorQuery) {
        boolean isFound = false;
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(authorQuery.trim())) {
                book.showDetails();
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println(" No books found by author: " + authorQuery);
        }
    }

    private void saveBookToFile(Book book) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(book.toFileString() + "\n");
        } catch (IOException e) {
            System.out.println(" Error saving to file: " + e.getMessage());
        }
    }

    private void loadBooksFromFile() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Book book = Book.fromFileString(line);
                if (book != null) {
                    bookList.add(book);
                }
            }
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }
}