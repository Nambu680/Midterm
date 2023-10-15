package Library;


public class NonFictionBook extends Book {
    private String topic;
    private String authorCountry;

    public NonFictionBook(String ISBN, String title, String author, int yearOfPublication, String genre,
                          String topic, String authorCountry) {
        super(ISBN, title, author, yearOfPublication, genre);
        this.topic = topic;
        this.authorCountry = authorCountry;
    }

    @Override
    public String toString() {
        return super.toString() + ", NonFictionBook{" +
                "topic='" + topic + '\'' +
                ", authorCountry='" + authorCountry + '\'' +
                '}';
    }
}

