package User;

import Library.Book;

import java.util.ArrayList;
import java.util.List;


public class Patron extends User {
    private int borrowedBooksLimit;
    private List<Book> borrowedBooks;


    public Patron(String username, String password, String firstName, String lastName, String email, String phoneNumber, int borrowedBooksLimit) {
        super(username, password, firstName, lastName, email, phoneNumber);
        borrowedBooks = new ArrayList<>(); // Initialize the borrowed
        this.borrowedBooksLimit = borrowedBooksLimit;
    }

    // Getters and setters for specific attributes


    @Override
    public String toString() {
        return super.toString() + ", Patron{" +
                "borrowedBooksLimit=" + borrowedBooksLimit +
                '}';
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public boolean hasBorrowedBook(Book book) {
        return borrowedBooks.contains(book);
    }
    public void returnBook(Book book) {
        borrowedBooks.remove(book); // Remove the book from the borrowed books
    }
    public List<Book> getBorrowedBooksByGenre(String genre) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : borrowedBooks) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }


}

