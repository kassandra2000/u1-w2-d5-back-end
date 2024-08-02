package kassandrafalsitta.entities;

import kassandrafalsitta.enums.Periodicity;

public class Magazine extends Catalog {
    private Periodicity periodicity;
    //costruttore

    public Magazine(String title, int yearOfPublication, int numberOfPages, Periodicity periodicity) {
        super(title, yearOfPublication, numberOfPages);
        this.periodicity = periodicity;
    }
    //getter e setter

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }
}
