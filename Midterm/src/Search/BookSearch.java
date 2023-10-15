package Search;


import Library.Book;

import java.util.ArrayList;
import java.util.List;

public class BookSearch {
    private final List<Book> bookList;

    public BookSearch(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByGenre(String genre) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByISBN(String ISBN) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                result.add(book);
            }
        }
        return result;
    }
}


