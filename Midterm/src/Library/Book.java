package Library;


public class Book {
    private String ISBN;
    private String title;
    private String author;
    private int yearOfPublication;
    private String genre;
    private boolean isAvailable;  // This is a flag to track availability

    public Book(String ISBN, String title, String author, int yearOfPublication, String genre) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
    }

    // Getters and setters for the attributes
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", genre='" + genre + '\'' +
                '}';
    }
}



