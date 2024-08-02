package kassandrafalsitta.entities;

import com.github.javafaker.Faker;
import kassandrafalsitta.enums.Periodicity;

import java.util.*;

public class Archive {
    public static List<Catalog> catalog = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Faker f = new Faker();
    static Random r = new Random();


    //esercizio 1
    public static void add() {
        while (true) {
            try {
                System.out.println("quale elemento vuoi aggiungere? \n 1.Libro \n 2.Rivista \n 0.Esci");
                String choice = sc.nextLine();
                if (Objects.equals(choice, "0")) {
                    break;
                } else {
                    switch (choice) {
                        case "1":
                            Book book = new Book(f.book().title(), r.nextInt(1980, 2024), r.nextInt(20, 500), f.book().author(), f.book().genre());
                            catalog.add(book);
                            System.out.println("libro aggiunto con successo");
                            break;
                        case "2":
                            Periodicity[] periocityList = Periodicity.values();
                            Magazine magazine = new Magazine(f.book().title(), r.nextInt(1980, 2024), r.nextInt(20, 500), periocityList[r.nextInt(periocityList.length)]);
                            catalog.add(magazine);
                            System.out.println("rivista aggiunta con successo");
                            break;
                        default:
                            System.out.println("scelta non valida riprova!");
                            break;

                    }
                }


            } catch (InputMismatchException e) {
                System.out.println("inserisci un valore valido");

            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }

    public static void delete() {
        while (true) {
            try {
                System.out.println("quale elemento vuoi eliminare? inserisci ISBN oppure 0 per uscire");
                for (int i = 0; i < catalog.size(); i++) {
                    System.out.println(catalog.get(i).getCodeIsbn() + " --> " + catalog.get(i).getTitle());
                }
                String choice = sc.nextLine();
                if (Objects.equals(choice, "0")) {
                    break;
                } else {
                    Optional<Catalog> itemSearch = catalog.stream().filter(singleItem -> singleItem.getCodeIsbn().equals(choice)).findFirst();
                    if (itemSearch.isPresent()) {
                        catalog.removeIf(item -> item.getCodeIsbn().equals(choice));

                    } else {
                        System.out.println("non è stato possibile trovare l'elemento\n");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("inserisci un valore valido");

            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
    }
}
