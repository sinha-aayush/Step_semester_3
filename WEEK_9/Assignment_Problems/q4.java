package WEEK_9.Assignment_Problems;

import java.util.Scanner;

abstract class Cab {
    abstract double getRate();

    double calculateFare(double km) {
        return Math.max(100, km * getRate());
    }
}

interface NightService {
    default double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class Mini extends Cab {
    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    double getRate() {
        return 14;
    }
}

class SUV extends Cab implements NightService {
    double getRate() {
        return 18;
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;

            switch (type) {
                case "MINI":
                    cab = new Mini();
                    break;
                case "SEDAN":
                    cab = new Sedan();
                    break;
                case "SUV":
                    cab = new SUV();
                    break;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(km);

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).applyNightCharge(fare);
            }

            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
