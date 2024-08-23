import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    private ArrayList<Book> books = new ArrayList<>();
    public static void main(String[] args) {
        App library = new App();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Adding some books for demonstration purposes
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(4, "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book(5, "Moby-Dick", "Herman Melville"));

        // Sorting the book list by title for binary search
        library.sortBooksByTitle();

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Search Book by Title (Linear Search)");
            System.out.println("2. Search Book by Title (Binary Search)");
            System.out.println("3. Add Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the title to search (Linear Search): ");
                    String linearSearchTitle = scanner.nextLine();
                    library.linearSearchByTitle(linearSearchTitle);
                    break;
                case 2:
                    System.out.print("Enter the title to search (Binary Search): ");
                    String binarySearchTitle = scanner.nextLine();
                    library.binarySearchByTitle(binarySearchTitle);
                    break;
                case 3:
                    library.addBookInteractive(scanner);
                    break;
                case 4:
                    library.displayAllBooks();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addBookInteractive(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        Book book = new Book(bookId, title, author);
        addBook(book);
        sortBooksByTitle();
        System.out.println("Book added successfully!");
    }

    public void linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void binarySearchByTitle(String title) {
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int compare = midBook.title.compareToIgnoreCase(title);

            if (compare == 0) {
                System.out.println("Book found: " + midBook);
                return;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Book not found!");
    }

    public void sortBooksByTitle() {
        Collections.sort(books, Comparator.comparing(book -> book.title.toLowerCase()));
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
