package WEEK_9.Practice_Problems;

import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;
    
    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }
    
    abstract double getFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }
    
    double getFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }
    
    double getFine() {
        double fine = daysLate * 5.0;
        return fine > 50.0 ? 50.0 : fine;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }
    
    double getFine() {
        return daysLate * 1.0;
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()){ sc.close(); return;}
        int n = sc.nextInt();
        LibraryItem[] items = new LibraryItem[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            if (type.equals("BOOK")) {
                items[i] = new Book(title, daysLate);
            } else if (type.equals("DVD")) {
                items[i] = new DVD(title, daysLate);
            } else if (type.equals("MAGAZINE")) {
                items[i] = new Magazine(title, daysLate);
            }
        }
        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.getFine();
            totalFines += fine;
            System.out.printf("%s: %.2f\n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
        sc.close();
    }
}
