package kassandrafalsitta;

import kassandrafalsitta.entities.Book;
import kassandrafalsitta.entities.Catalog;
import kassandrafalsitta.entities.Magazine;
import kassandrafalsitta.enums.Periodicity;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static kassandrafalsitta.entities.Archive.*;

public class Application {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        add();
//        searchForAuthor();
        while (true) {
            try {
                System.out.println("quale operazione vuoi effettuare?");
                System.out.println(" 1. Aggiungi\n 2. Elimina\n 3. Cerca per ISBN\n 4. Cerca per anno\n 5.Cerca per autore\n 0. Per uscire ");
                String choice = sc.nextLine();
                if (Objects.equals(choice, "0")) {
                    break;
                } else {

                    switch (choice) {

                        case "1":
                            //esercizio 1
                            add();
                            break;
                        case "2":
                            //esercizio 2
                            delete();
                            break;
                        case "3":
                            //esercizio 3
                            searchForIsbn();
                            break;
                        case "4":
                            //esercizio 4
                            searchForYear();
                            break;
                        case "5":
                            //esercizio 5
                            searchForAuthor();
                            break;
                        default:
                            System.out.println("scelta non valida riprova!\n");
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("inserisci un valore valido");

            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }
        sc.close();

        saveCatalog();
    }

    public static void saveCatalog() {
        File file = new File("src/main/java/kassandrafalsitta/discoArchivio.txt");

        try {
            //aggiunge una lista di file
            FileUtils.writeStringToFile(file, addFileList(catalog) + System.lineSeparator(), StandardCharsets.UTF_8, true);
            //---------------------------lettura------------------------------------
            String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            readFile(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String addFileList(List<Catalog> catalog) {
        return catalog.stream().map(product -> {
            if (product instanceof Book) {
                return product.getTitle() + "@" + product.getCodeIsbn() + "@" + product.getYearOfPublication() + "@" + product.getNumberOfPages() + "@" + ((Book) product).getAuthor() + "@" + ((Book) product).getGenre();
            } else if (product instanceof Magazine) {
                return product.getTitle() + "@" + product.getCodeIsbn() + "@" + product.getYearOfPublication() + "@" + product.getNumberOfPages() + "@" + ((Magazine) product).getPeriodicity();
            } else {
                System.out.println("errore");
                return "";
            }
        }).collect(Collectors.joining(System.lineSeparator()));
    }

    public static void readFile(String content) {
        String[] contentArr = content.split(System.lineSeparator());
        List<Catalog> catalogs = new ArrayList<>();

        for (String line : contentArr) {
            String[] strArr = line.split("@");
            if (strArr.length == 6) {
                String title = strArr[0];
                int yearOfPublication = Integer.parseInt(strArr[2]);
                int numberOfPages = Integer.parseInt(strArr[3]);
                String author = strArr[4];
                String genre = strArr[5];

                Book book = new Book(title, yearOfPublication, numberOfPages, author, genre);
                catalogs.add(book);
            } else if (strArr.length == 5) {
                String title = strArr[0];
                int yearOfPublication = Integer.parseInt(strArr[2]);
                int numberOfPages = Integer.parseInt(strArr[3]);
                String periodicity = strArr[4];
                Magazine magazine = new Magazine(title, yearOfPublication, numberOfPages, Periodicity.valueOf(periodicity.toUpperCase()));
                catalogs.add(magazine);


            } else {
                System.out.println("non hai inserito niente: " + line);
            }
        }

        catalogs.forEach(System.out::println);
    }

}
