package WEEK_8.Practice_Problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract LocalDate calculateDueDate(LocalDate currentDate);
    public String getTitle() { return title; }
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14); // 14 days borrowing period[cite: 22]
    }
}

class Dvd extends LibraryItem {
    public Dvd(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7); // 7 days borrowing period[cite: 22]
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3); // 3 days borrowing period[cite: 22]
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        LibraryItem[] items = new LibraryItem[n];
        LocalDate currentDate = LocalDate.parse("2023-10-26"); // current date fixed[cite: 22]

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next().replace("\"", "");
            if (type.equals("BOOK")) {
                items[i] = new Book(title);
            } else if (type.equals("DVD")) {
                items[i] = new Dvd(title);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new Magazine(title);
            }
        }

        for (int i = 0; i < n; i++) {
            LocalDate dueDate = items[i].calculateDueDate(currentDate);
            System.out.println(items[i].getTitle() + ": " + dueDate);
        }
        scanner.close();
    }
}