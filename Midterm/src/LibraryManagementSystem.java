/**
 *                                       READ ME
 * The Library Management System handles the interaction between patrons and librarians
 * for managing books in a library.
 *
 * <p>
 * This program allows patrons to search and borrow books and librarians to manage
 * the library's book collection.
 * </p>
 *
 * <p>
 * The main method serves as the entry point for the application, and it provides a menu-driven
 * interface for users to interact with the library system.
 * </p>
 *
 * <p>
 * To use the Library Management System, follow these steps:
 * <ol>
 *   <li>Launch the application.</li>
 *   <li>Choose "Patron Login" or "Librarian Login" based on your role.</li>
 *   <li>Follow the menu options to search, borrow, return, and manage books as a patron or librarian.</li>
 *   <li>Log out when you are done, or exit the application.</li>
 * </ol>
 * </p>
 */

import Collection.BookCollection;
import Library.Book;
import Search.BookSearch;
import User.Librarian;
import User.Patron;
import Library.MysteryBook;
import Library.NonFictionBook;
import Library.FictionBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Create a BookCollection instance
        BookCollection bookCollection = new BookCollection();

        // Book List
        List<Book> books = bookCollection.getAllBooks();


        // Create Book objects
        FictionBook fictionBook1 = new FictionBook("001", "Alice in Wonderland", "Author 1", 2023, "Fiction", "Alice", "Wonderland", "Adventure");
        FictionBook fictionBook2 = new FictionBook("002", "The Shooter", "Author 2", 2023, "Fiction", "Protagonist", "Fantasy World", "Adventure");
        NonFictionBook nonFictionBook1 = new NonFictionBook("003", "Trees", "Author 3", 2010, "Non-Fiction", "Science History", "United States");
        NonFictionBook nonFictionBook2 = new NonFictionBook("004", "Countries", "Author 4", 2022, "Non-Fiction", "History", "United States");
        MysteryBook mysteryBook1 = new MysteryBook("005", "Sherlock Holmes", "Author 5", 2022, "Mystery", "Sherlock Holmes", "Hidden clues", "Murder Mystery");
        MysteryBook mysteryBook2 = new MysteryBook("006", "Marple", "Author 6", 2023, "Mystery", "Miss Marple", "Cryptic clues", "Whodunit");

        // Add the Book objects to the BookCollection
        bookCollection.addBook(fictionBook1);
        bookCollection.addBook(fictionBook2);
        bookCollection.addBook(nonFictionBook1);
        bookCollection.addBook(nonFictionBook2);
        bookCollection.addBook(mysteryBook1);
        bookCollection.addBook(mysteryBook2);

        // Create sample users (patrons and a librarian)
        Patron patron1 = new Patron("patron1", "password1", "John", "Doe", "john@gmail.com", "1234567890", 3);
        Patron patron2 = new Patron("patron2", "password2", "Jane", "Smith", "jane@yahoo.com", "9876543210", 2);
        Librarian librarian1 = new Librarian("librarian1", "librarian123", "Izaiah", "Smith", "smith@hotmail.com", "8085555555", "L123");
        Librarian librarian2 = new Librarian("librarian2", "librarian456", "Sonny", "Doe", "doe@microsoft.com", "8087777777", "L456");

        // Create a book search
        BookSearch bookSearch = new BookSearch(books);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Library Management System");
            System.out.println("1. Patron Login");
            System.out.println("2. Librarian Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            if (scanner.hasNextInt()) { // Check for integer input
                choice = scanner.nextInt(); // Read the integer choice
                scanner.nextLine();
            } else {
                scanner.nextLine(); // Consume the invalid input
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    Patron loggedPatron = null;
                    System.out.print("Enter username: ");
                    String patronUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String patronPassword = scanner.next();

                    // Check if a patron with the provided username and password exists
                    for (Patron patron : List.of(patron1, patron2)) {
                        if (patron.getUsername().equals(patronUsername) && patron.getPassword().equals(patronPassword)) {
                            loggedPatron = patron;
                            break;
                        }
                    }
                    if (loggedPatron != null) {
                        System.out.println("Welcome, " + loggedPatron.getFirstName() + "!");
                        boolean patronLoggedIn = true;
                        while (patronLoggedIn) {
                            System.out.println("Patron Menu");
                            System.out.println("1. Search for Books by Title");
                            System.out.println("2. Search for Books by Author");
                            System.out.println("3. Search for Books by ISBN");
                            System.out.println("4. Search for Books by Genre");
                            System.out.println("5. Borrow a book");
                            System.out.println("6. Return a book");
                            System.out.println("7. View Borrowed Books by Genre");
                            System.out.println("8. Logout and return to the main menu");
                            System.out.print("Enter your choice: ");

                            if (scanner.hasNextInt()) { // Check for integer input
                                int patronChoice = scanner.nextInt(); // Read the integer choice
                                scanner.nextLine(); // Consume the newline character

                                switch (patronChoice) {
                                    case 1 -> {
                                        // Patron searches for books by title
                                        System.out.print("Enter the title to search for: ");
                                        String titleToSearch = scanner.nextLine().trim().toLowerCase(); // Trim and convert to lowercase
                                        List<Book> foundBooks = new ArrayList<>();
                                        for (Book book : books) {
                                            if (book.getTitle().toLowerCase().contains(titleToSearch)) { // Case-insensitive search
                                                foundBooks.add(book);
                                            }
                                        }
                                        if (foundBooks.isEmpty()) {
                                            System.out.println("No books found with the provided title.");
                                        } else {
                                            System.out.println("Books found:");
                                            for (Book book : foundBooks) {
                                                System.out.println(book);
                                            }
                                        }
                                    }
                                    case 2 -> {
                                        // Patron searches for books by Author
                                        System.out.print("Enter the Author to search for: ");
                                        String authorToSearch = scanner.nextLine().trim().toLowerCase(); // Trim and convert to lowercase
                                        List<Book> foundBooks = new ArrayList<>();
                                        for (Book book : bookCollection.getAllBooks()) {
                                            if (book.getAuthor().toLowerCase().contains(authorToSearch)) { // Case-insensitive search
                                                foundBooks.add(book);
                                            }
                                        }
                                        if (foundBooks.isEmpty()) {
                                            System.out.println("No books found by the provided author.");
                                        } else {
                                            System.out.println("Books found:");
                                            for (Book book : foundBooks) {
                                                System.out.println(book);
                                            }
                                        }
                                    }
                                    case 3 -> {
                                        // Patron searches for books by ISBN
                                        System.out.print("Enter the ISBN to search for: ");
                                        String isbnToSearch = scanner.next();
                                        List<Book> foundBooks = bookSearch.searchByISBN(isbnToSearch);
                                        if (foundBooks.isEmpty()) {
                                            System.out.println("No books found with the provided ISBN.");
                                        } else {
                                            System.out.println("Books found:");
                                            for (Book book : foundBooks) {
                                                System.out.println(book);
                                            }
                                        }
                                    }
                                    case 4 -> {
                                        // Patron searches for books by Genre
                                        System.out.print("Enter the Genre to search for: ");
                                        String genreToSearch = scanner.next();
                                        List<Book> foundBooks = bookSearch.searchByGenre(genreToSearch);
                                        if (foundBooks.isEmpty()) {
                                            System.out.println("No books found in the provided Genre.");
                                        } else {
                                            System.out.println("Books found:");
                                            for (Book book : foundBooks) {
                                                System.out.println(book);
                                            }
                                        }
                                    }
                                    case 5 -> {
                                        // Patron borrows a book
                                        System.out.print("Enter the ISBN of the book to borrow: ");
                                        String isbnToBorrow = scanner.next();

                                        // Use the searchByISBN method to find the books with the specified ISBN
                                        List<Book> booksToBorrow = bookSearch.searchByISBN(isbnToBorrow);

                                        if (booksToBorrow.isEmpty()) {
                                            System.out.println("Book not found. Please check the ISBN and try again.");
                                        } else if (booksToBorrow.size() == 1) {
                                            Book bookToBorrow = booksToBorrow.get(0);

                                            // Check if the book is available for borrowing
                                            if (bookCollection.isBookAvailable(bookToBorrow)) {
                                                // Borrow the book and add it to the patron's borrowed books
                                                loggedPatron.borrowBook(bookToBorrow);
                                                bookCollection.borrowBook(bookToBorrow);
                                                System.out.println("Book borrowed successfully.");
                                            } else {
                                                System.out.println("The book is not available for borrowing.");
                                            }
                                        } else {
                                            System.out.println("Multiple books found with the same ISBN. Please specify the exact book.");
                                        }
                                    }
                                    case 6 -> {
                                        // Patron returns a book
                                        System.out.print("Enter the ISBN of the book to return: ");
                                        String isbnToReturn = scanner.next();

                                        // Search for the book to return
                                        List<Book> booksToReturn = bookSearch.searchByISBN(isbnToReturn);

                                        if (booksToReturn.isEmpty()) {
                                            System.out.println("Book not found in your borrowed books. Please check the ISBN and try again.");
                                        } else if (booksToReturn.size() == 1) {
                                            Book bookToReturn = booksToReturn.get(0);

                                            // Check if the book belongs to the patron
                                            if (loggedPatron.hasBorrowedBook(bookToReturn)) {
                                                // Return the book
                                                loggedPatron.returnBook(bookToReturn);
                                                bookCollection.returnBook(bookToReturn);
                                                System.out.println("Book returned successfully.");
                                            } else {
                                                System.out.println("This book doesn't belong to you.");
                                            }
                                        } else {
                                            System.out.println("Multiple books found with the same ISBN. Please specify the exact book.");
                                        }
                                    }
                                    case 7 -> {
                                        // Patron views borrowed books by genre
                                        System.out.print("Enter the genre to filter by: ");
                                        String genreToFilter = scanner.next();

                                        // Use the getBorrowedBooksByGenre method to get borrowed books by genre
                                        List<Book> patronBorrowedBooks = loggedPatron.getBorrowedBooksByGenre(genreToFilter);

                                        if (patronBorrowedBooks.isEmpty()) {
                                            System.out.println("No books in the selected genre have been borrowed.");
                                        } else {
                                            System.out.println("Borrowed books in the selected genre:");
                                            for (Book book : patronBorrowedBooks) {
                                                System.out.println(book);
                                            }
                                        }
                                    }
                                    case 8 -> {
                                        patronLoggedIn = false;
                                        System.out.println("Logging out as a patron.");
                                    }
                                    default -> System.out.println("Invalid choice. Please try again.");
                                }
                            } else {
                                scanner.nextLine(); // Consume the invalid input
                                System.out.println("Invalid input. Please enter a number.");
                            }
                        }
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                }
                case 2 -> {
                    Librarian loggedInLibrarian = null;
                    System.out.print("Enter username: ");
                    String librarianUsername = scanner.next();
                    System.out.print("Enter password: ");
                    String librarianPassword = scanner.next();

                    // Check if a librarian with the provided username and password exists
                    for (Librarian librarian : List.of(librarian1, librarian2)) {
                        if (librarian.getUsername().equals(librarianUsername) && librarian.getPassword().equals(librarianPassword)) {
                            loggedInLibrarian = librarian;
                            break;
                        }
                    }
                    if (loggedInLibrarian != null) {
                        System.out.println("Welcome, Librarian " + loggedInLibrarian.getFirstName() + "!");

                        boolean librarianLoggedIn = true;
                        while (librarianLoggedIn) {
                            System.out.println("Librarian Menu");
                            System.out.println("1. Add a Book");
                            System.out.println("2. Update Book Information");
                            System.out.println("3. Delete a Book");
                            System.out.println("4. List books by genre");
                            System.out.println("5. Return to Main Menu");
                            System.out.print("Enter your choice: ");

                            int librarianChoice = scanner.nextInt();

                            switch (librarianChoice) {
                                case 1 -> {
                                    // Librarian adds a book
                                    System.out.print("Enter ISBN: ");
                                    String isbn = scanner.next();
                                    System.out.print("Enter Title: ");
                                    String title = scanner.next();
                                    System.out.print("Enter Author: ");
                                    String author = scanner.next();
                                    System.out.print("Enter Year of Publication: ");
                                    int year = scanner.nextInt();
                                    System.out.print("Enter Genre: ");
                                    String genre = scanner.next();
                                    Book newBook = new Book(isbn, title, author, year, genre);
                                    bookCollection.addBook(newBook);
                                    System.out.println("Book added successfully.");
                                }
                                case 2 -> {
                                    // Librarian updates book information
                                    System.out.print("Enter ISBN of the book to update: ");
                                    String isbnToUpdate = scanner.next();

                                    // Check if the ISBN exists
                                    Book bookToUpdate = bookCollection.getBookByISBN(isbnToUpdate);
                                    if (bookToUpdate == null) {
                                        System.out.println("No book with ISBN " + isbnToUpdate + " found for update.");
                                    } else {
                                        // Prompt for what you want to update (author, genre, or year)
                                        System.out.println("Select what you want to update:");
                                        System.out.println("1. Author");
                                        System.out.println("2. ISBN");
                                        System.out.println("3. Genre");
                                        System.out.println("4. Year of Publication");
                                        System.out.print("Enter your choice: ");
                                        int updateChoice = scanner.nextInt();
                                        scanner.nextLine(); // Consume the newline character

                                        switch (updateChoice) {
                                            case 1 -> {
                                                System.out.print("Enter new author: ");
                                                String newAuthor = scanner.nextLine();
                                                bookToUpdate.setAuthor(newAuthor);
                                                System.out.println("Author updated successfully.");
                                            }
                                            case 2 -> {
                                                // Prompt for the new ISBN and check if it's already in use
                                                System.out.print("Enter new ISBN: ");
                                                String newISBN = scanner.next();

                                                // Check if the new ISBN is already in use by another book
                                                boolean isbnAlreadyUsed = bookCollection.isISBNAlreadyUsed(newISBN);

                                                if (isbnAlreadyUsed) {
                                                    System.out.println("ISBN " + newISBN + " is already in use by another book. Update failed.");
                                                } else {
                                                    bookToUpdate.setISBN(newISBN);
                                                    System.out.println("ISBN updated successfully.");
                                                }
                                            }
                                            case 3 -> {
                                                System.out.print("Enter new genre: ");
                                                String newGenre = scanner.nextLine();
                                                bookToUpdate.setGenre(newGenre);
                                                System.out.println("Genre updated successfully.");
                                            }
                                            case 4 -> {
                                                System.out.print("Enter new year of publication: ");
                                                int newYear = scanner.nextInt();
                                                bookToUpdate.setYearOfPublication(newYear);
                                                System.out.println("Year of publication updated successfully.");
                                            }
                                            default -> System.out.println("Invalid choice. Please try again.");
                                        }
                                    }
                                }
                                case 3 -> {
                                    // Librarian deletes a book
                                    System.out.print("Enter ISBN of the book to remove: ");
                                    String isbnToDelete = scanner.next();

                                    // Call a method to remove the book by ISBN
                                    boolean removed = bookCollection.removeBookByISBN(isbnToDelete);

                                    if (removed) {
                                        System.out.println("Book with ISBN " + isbnToDelete + " has been successfully removed.");
                                    } else {
                                        System.out.println("No book with ISBN " + isbnToDelete + " found for removal.");
                                    }
                                }
                                case 4 -> {
                                    // Librarian lists books by genre
                                    System.out.print("Enter the genre to filter by: ");
                                    String genreToFilter = scanner.next();

                                    // Use the new method to get books by genre
                                    List<Book> booksByGenre = bookCollection.getBooksByGenre(genreToFilter);

                                    if (booksByGenre.isEmpty()) {
                                        System.out.println("No books in the selected genre found.");
                                    } else {
                                        System.out.println("Books in the selected genre:");
                                        for (Book book : booksByGenre) {
                                            System.out.println(book);
                                        }
                                    }
                                }
                                case 5 -> {
                                    librarianLoggedIn = false;
                                    System.out.println("Logging out as a librarian.");
                                }
                                default -> System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                }
                case 3 -> {
                    running = false;
                    System.out.println("Goodbye! Thank you for using the Library Management System.");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}






