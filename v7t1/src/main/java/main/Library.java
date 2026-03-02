package main;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    
    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void listBooks() {
        int totalCopies = 0;
        for (Book b : books) {
            b.displayInfo();
            System.out.println("Kirjan kategoria: " + b.categorize());
            totalCopies += b.copies;
        }
        System.out.println("Kirjojen määrä kirjastossa on: " + totalCopies);
    }
}
