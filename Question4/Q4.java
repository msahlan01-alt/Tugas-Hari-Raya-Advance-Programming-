package Question4; // package name sesuai dengan nama folder
public class Q4 {
    public static void main(String[] args) {

        Dvd d = new Dvd("Baby be Mine", 1982, 50000, 4);
        Magazine m = new Magazine("Nintendo Power #82", 1997, 25000, "Nintendo", 36);
        Vinyl v = new Vinyl("Song of The Wind", 1967, 350000, 12);

        d.getDescription();
        System.out.println();

        m.getDescription();
        System.out.println();

        v.getDescription();
    }
}

// Base class
class Item {
    String title;
    int year;
    double price;

    Item(String title, int year, double price) {
        if (title.length() >= 255) throw new IllegalArgumentException();
        if (year <= 1800 || year >= 2026) throw new IllegalArgumentException();

        this.title = title;
        this.year = year;
        this.price = price;
    }

    void getDescription() {
        System.out.println("Title: " + title);
        System.out.println("releaseYear: " + year);
        System.out.println("Price: " + (int)price);
    }
}

// DVD
class Dvd extends Item {
    double runtime;

    Dvd(String t, int y, double p, double r) {
        super(t, y, p);
        if (r >= 720) throw new IllegalArgumentException();
        this.runtime = r;
    }

    @Override
    void getDescription() {
        super.getDescription();
        System.out.println("Runtime: " + (int)runtime + " minutes");
    }
}

// Magazine
class Magazine extends Item {
    String author;
    int pages;

    Magazine(String t, int y, double p, String a, int pg) {
        super(t, y, p);
        if (a.length() >= 50) throw new IllegalArgumentException();
        this.author = a;
        this.pages = pg;
    }

    @Override
    void getDescription() {
        super.getDescription();
        System.out.println("Author: " + author);
        System.out.println("Number of Pages: " + pages);
    }
}

// Vinyl
class Vinyl extends Item {
    int size;

    Vinyl(String t, int y, double p, int s) {
        super(t, y, p);
        if (s > 12) throw new IllegalArgumentException();
        this.size = s;
    }

    @Override
    void getDescription() {
        super.getDescription();
        System.out.println("Size in inches: " + size);
    }
}