package Library;


public class MysteryBook extends Book {
    private String detective;
    private String clues;
    private String crimeType;

    public MysteryBook(String ISBN, String title, String author, int yearOfPublication, String genre,
                       String detective, String clues, String crimeType) {
        super(ISBN, title, author, yearOfPublication, genre);
        this.detective = detective;
        this.clues = clues;
        this.crimeType = crimeType;
    }

    @Override
    public String toString() {
        return super.toString() + ", MysteryBook{" +
                "detective='" + detective + '\'' +
                ", clues='" + clues + '\'' +
                ", crimeType='" + crimeType + '\'' +
                '}';
    }
}

