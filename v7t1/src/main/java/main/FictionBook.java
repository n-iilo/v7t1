package main;

public class FictionBook extends Book implements Borrowable {
    private int borrowedCopies = 0;

    public FictionBook(String title, String author, int pages, int copies) {
        super(title, author, pages, copies);
    }

    @Override
    public String categorize() {
        return "Fiktiokirja";
    }

    @Override
    public void borrow() {
        if (this.copies > 0) {
            this.copies--;
            this.borrowedCopies++;
            System.out.println("Kirja " + title + " on nyt lainattu.");
        } else {
            System.out.println("Kirjaa ei löytynyt tai sitä ei voi lainata.");
        }
    }
    
    @Override
    public void returnBook() {
        if (this.borrowedCopies > 0) {
            this.copies++;
            this.borrowedCopies--;
            System.out.println("Kirja " + title + " on palautettu.");
        } else {
            System.out.println("Kirja " + title + " ei ole lainassa.");
        }
    }
}
