package Question5; // package name sesuai dengan nama folder
import java.util.*;
public class Q5 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Stack<Book> stack = new Stack<>();

            // Ini Preload (3 contoh sudah cukup, tapi boleh ditambahkan sebanyak 2 lagi)
            stack.push(new Book("Why Black Moves First", "Wesley So", 2025));
            stack.push(new GeneralBook("Inside Black Mesa", "Dr. Isaac Kleiner", 1997, "Documentary"));
            stack.push(new ChildrenBook("Got Science?", "Rachel Dawes", 2015, 5, true));

            int choice;

            do {
                System.out.println("\nMENU OPTIONS:");
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Delete Book");
                System.out.println("0. Exit");
                System.out.print("Choose: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.println("1. GeneralBook");
                        System.out.println("2. ChildrenBook");
                        System.out.print("Choose type: ");
                        int type = sc.nextInt();
                        sc.nextLine();

                        // Input dan Validasi (semua input harus divalidasi, jika tidak valid, maka kodingan akan meminta input ulang sampai valid)
                        System.out.print("Title: ");
                        String t = sc.nextLine();
                        while (t.length() >= 255) {
                            System.out.print("Title too long, re-enter: ");
                            t = sc.nextLine();
                        }

                        System.out.print("Author: ");
                        String a = sc.nextLine();
                        while (a.length() >= 50) {
                            System.out.print("Author too long, re-enter: ");
                            a = sc.nextLine();
                        }

                        System.out.print("Year: ");
                        int y = sc.nextInt();
                        while (y <= 1800 || y >= 2026) {
                            System.out.print("Invalid year, re-enter: ");
                            y = sc.nextInt();
                        }

                        if (type == 1) {
                            sc.nextLine();
                            System.out.print("Genre: ");
                            String g = sc.nextLine();
                            while (g.length() > 30) {
                                System.out.print("Genre too long, re-enter: ");
                                g = sc.nextLine();
                            }

                            stack.push(new GeneralBook(t, a, y, g));
                            System.out.println("GeneralBook added!");

                        } else if (type == 2) {
                            System.out.print("Min Age: ");
                            int m = sc.nextInt();
                            while (m <= 3 || m >= 12) {
                                System.out.print("Invalid age, re-enter: ");
                                m = sc.nextInt();
                            }

                            System.out.print("Has Visual (true/false): ");
                            boolean v = sc.nextBoolean();
                            stack.push(new ChildrenBook(t, a, y, m, v));
                            System.out.println("ChildrenBook added!");
                        }
                    }

                    case 2 -> {
                        if (stack.isEmpty()) {
                            System.out.println("No books.");
                        } else {
                            System.out.println("\nBOOK LIST:");
                            for (Book b : stack) {
                                b.getInfo();
                                System.out.println();
                            }
                        }
                    }

                    case 3 -> {
                        if (!stack.isEmpty()) {
                            stack.pop();
                            System.out.println("Last book deleted.");
                        } else {
                            System.out.println("Stack empty.");
                        }
                    }
                }

            } while (choice != 0);
            System.out.println("Program ended.");
        }
    }
}

// Ini Book (Kategori ini buat semua jenis buku, termasuk GeneralBook dan ChildrenBook)
class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    void getInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publication: " + year);
    }
}

// Ini GeneralBook (Kategori buku umum, dengan tambahan atribut genre)
class GeneralBook extends Book {
    String genre;

    GeneralBook(String t, String a, int y, String g) {
        super(t, a, y);
        this.genre = g;
    }

    @Override
    void getInfo() {
        super.getInfo();
        System.out.println("Genre: " + genre);
    }
}

// Ini ChildrenBook (Kategori buku anak-anak, dengan tambahan atribut minimum age dan apakah ada visualisasi atau tidak)
class ChildrenBook extends Book {
    int minAge;
    boolean hasVisual;

    ChildrenBook(String t, String a, int y, int m, boolean v) {
        super(t, a, y);
        this.minAge = m;
        this.hasVisual = v;
    }

    @Override
    void getInfo() {
        super.getInfo();
        System.out.println("Minimum Age: " + minAge);
        System.out.println("Has Visualisation: " + (hasVisual ? "Yes" : "No"));
    }
}