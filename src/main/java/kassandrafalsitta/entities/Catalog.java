package kassandrafalsitta.entities;

import com.github.javafaker.Faker;

public abstract class Catalog {
    private final String codeIsbn;
    private String title;
    private int yearOfPublication;
    private int numberOfPages;
    //costruttore

    public Catalog(String title, int yearOfPublication, int numberOfPages) {
        Faker f = new Faker();
        this.codeIsbn = f.code().isbn10();
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
    }
    //getter e setter


    public String getCodeIsbn() {
        return codeIsbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "codeIsbn='" + codeIsbn + '\'' +
                ", title='" + title + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
