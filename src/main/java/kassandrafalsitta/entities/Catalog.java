package kassandrafalsitta.entities;

import java.util.Random;

public abstract class Catalog {
    private long codeIsbn;
    private String title;
    private int yearOfPublication;
    private int numberOfPages;
    //costruttore

    public Catalog(String title, int yearOfPublication, int numberOfPages) {
        Random r = new Random();
        this.codeIsbn = r.nextLong(11111111, 999999999);
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
    }
    //getter e setter

    public long getCodeIsbn() {
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
}
