package main;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää kirja\r\n" + //
                                "2) Listaa kirjat\r\n" + //
                                "3) Lainaa fiktiokirja\r\n" + //
                                "4) Palauta fiktiokirja\r\n" + //
                                "0) Lopeta ohjelma");
            
            int i = Integer.parseInt(sc.nextLine());

            switch (i) {
                case 1:
                    System.out.println("Minkä kirjan haluat lisätä kirjastoon? 1) Fiktiokirja, 2) Tietokirja");
                    int type = Integer.parseInt(sc.nextLine());
                    System.out.println("Anna kirjan nimi:");
                    String title = sc.nextLine();
                    System.out.println("Anna kirjailijan nimi:");
                    String author = sc.nextLine();
                    System.out.println("Anna sivumäärä:");
                    int pages = Integer.parseInt(sc.nextLine());
                    System.out.println("Anna kirjojen määrä:");
                    int copies = Integer.parseInt(sc.nextLine());

                    if (type == 1) {
                        library.addBook(new FictionBook(title, author, pages, copies));
                    } else {
                        library.addBook(new NonFictionBook(title, author, pages, copies));
                    }
                    break;
                case 2:
                    library.listBooks();
                    break;
                case 3:
                    System.out.println("Anna lainattavan kirjan nimi:");
                    String borrowName = sc.nextLine();
                    Book borrowBook = null;
                    
                    for (Book b : library.getBooks()) {
                        if (b.title.equalsIgnoreCase(borrowName)) {
                            borrowBook = b;
                            break;
                        }
                    }

                    if (borrowBook == null || !(borrowBook instanceof Borrowable)) {
                        System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
                    } else {
                        ((Borrowable) borrowBook).borrow();
                    }
                    break;
                case 4:
                    System.out.println("Anna palautettavan kirjan nimi:");
                    String returnName = sc.nextLine();
                    Book returnBook = null;
                    
                    for (Book r : library.getBooks()) {
                        if (r.title.equalsIgnoreCase(returnName)) {
                            returnBook = r;
                            break;
                        }
                    }

                    if (returnBook == null || !(returnBook instanceof Borrowable)) {
                        System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
                    } else {
                        ((Borrowable) returnBook).returnBook();
                    }
                    break;
                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    exit = true;
                    break;
                default:
                    System.err.println("Virheellinen valinta, yritä uudelleen.");
                    break;
            }
        }
        sc.close();
    }
}
