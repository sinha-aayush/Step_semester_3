package WEEK_9.Assignment_Problems;

import java.util.Scanner;

abstract class Ticket {
    protected static final double CONVENIENCE_FEE = 20;

    abstract double getPrice();

    double calculateAmount(int count) {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class Regular extends Ticket {
    double getPrice() {
        return 150;
    }
}

class Premium extends Ticket {
    double getPrice() {
        return 250;
    }
}

class Recliner extends Ticket {
    double getPrice() {
        return 400;
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket = null;

            switch (seat) {
                case "REGULAR":
                    ticket = new Regular();
                    break;
                case "PREMIUM":
                    ticket = new Premium();
                    break;
                case "RECLINER":
                    ticket = new Recliner();
                    break;
            }

            double amount = ticket.calculateAmount(count);
            total += amount;

            System.out.printf("%s: %.2f%n", seat, amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}