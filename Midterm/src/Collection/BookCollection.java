package Collection;

import Library.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    private List<Book> books;
    private List<Book> availableBooks;
    private List<Book> borrowedBooks;

    public BookCollection() {
        books = new ArrayList<>();
        availableBooks = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }

    public boolean isBookAvailable(Book book) {
        // Implement the logic to check if a book is available
        return availableBooks.contains(book);
    }

    public void borrowBook(Book book) {
        if (availableBooks.contains(book)) {
            availableBooks.remove(book); // Remove the book from the available books
            borrowedBooks.add(book); // Add the book to the borrowed books
        }
    }
    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        availableBooks.add(book); // Add the book to the available books initially
    }
    public void returnBook(Book book) {
        borrowedBooks.remove(book); // Remove the book from the borrowed books
        availableBooks.add(book); // Add the book back to the available books
    }
    public Book getBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null; // Return null if the book with the specified ISBN is not found
    }
    public boolean removeBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                availableBooks.remove(book);
                return books.remove(book);
            }
        }
        return false; // Book with the specified ISBN not found.
    }
    public boolean isISBNAlreadyUsed(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return true; // ISBN is already in use
            }
        }
        return false; // ISBN is not in use
    }
    public List<Book> getBooksByGenre(String genre) {
        List<Book> booksByGenre = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                booksByGenre.add(book);
            }
        }
        return booksByGenre;
    }


}




