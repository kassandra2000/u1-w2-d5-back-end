package kassandrafalsitta.entities;

public class Book extends Catalog {
    private String author;
    private String genre;

    //costruttore
    public Book(String title, int yearOfPublication, int numberOfPages, String author, String genre) {
        super(title, yearOfPublication, numberOfPages);
        this.author = author;
        this.genre = genre;
    }
    //getter e setter

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
