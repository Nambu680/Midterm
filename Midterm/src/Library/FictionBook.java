package Library;

public class FictionBook extends Book {
    private String mainCharacter;
    private String setting;
    private String plotType;

    public FictionBook(String ISBN, String title, String author, int yearOfPublication, String genre,
                       String mainCharacter, String setting, String plotType) {
        super(ISBN, title, author, yearOfPublication, genre);
        this.mainCharacter = mainCharacter;
        this.setting = setting;
        this.plotType = plotType;
    }

    @Override
    public String toString() {
        return super.toString() + ", FictionBook{" +
                "mainCharacter='" + mainCharacter + '\'' +
                ", setting='" + setting + '\'' +
                ", plotType='" + plotType + '\'' +
                '}';
    }
}

