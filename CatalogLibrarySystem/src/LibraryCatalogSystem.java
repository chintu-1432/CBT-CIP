import java.util.Scanner;

public class LibraryCatalogSystem {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            LibraryCatalog catalog = new LibraryCatalog();
            int option;
            
            System.out.println(" Welcome to the Library Catalog System");
            
            do {
                System.out.println("\n======= MENU =======");
                System.out.println("1 Add Book");
                System.out.println("2 Show All Books");
                System.out.println("3 Search by Title");
                System.out.println("4 Search by Author");
                System.out.println("0 Exit");
                System.out.print("Choose an option: ");
                
                while (!input.hasNextInt()) {
                    System.out.println(" Invalid input. Please enter a number.");
                    input.next();
                }
                
                option = input.nextInt();
                input.nextLine(); // consume newline
                
                switch (option) {
                    case 1 -> {
                        System.out.print("Enter Book Title: ");
                        String title = input.nextLine();
                        
                        System.out.print("Enter Author Name: ");
                        String author = input.nextLine();
                        
                        System.out.print("Enter ISBN Number: ");
                        String isbn = input.nextLine();
                        
                        Book newBook = new Book(title, author, isbn);
                        catalog.addBook(newBook);
                    }
                    
                    case 2 -> catalog.displayAllBooks();
                    
                    case 3 -> {
                        System.out.print("Enter Title to Search: ");
                        String titleSearch = input.nextLine();
                        catalog.findByTitle(titleSearch);
                    }
                    
                    case 4 -> {
                        System.out.print("Enter Author to Search: ");
                        String authorSearch = input.nextLine();
                        catalog.findByAuthor(authorSearch);
                    }
                    
                    case 0 -> System.out.println(" Exiting Library System. Thank you!");
                    
                    default -> System.out.println(" Invalid choice. Try again.");
                }
            } while (option != 0);
        }
    }
}