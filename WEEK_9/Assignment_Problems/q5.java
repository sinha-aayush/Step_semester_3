package WEEK_9.Assignment_Problems;

import java.util.Scanner;

abstract class Appliance {
    abstract double getPower();

    double calculateUnits(double hours) {
        return getPower() * hours / 1000;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

interface SaverMode {
    default double applySaver(double units) {
        return units * 0.75;
    }
}

class Fridge extends Appliance {
    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    double getPower() {
        return 1500;
    }
}

class TV extends Appliance {
    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    double getPower() {
        return 500;
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance = null;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AC();
                    break;
                case "TV":
                    appliance = new TV();
                    break;
                case "WASHER":
                    appliance = new Washer();
                    break;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(hours);

            if (saver) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = appliance.calculateCost(units);
            totalCost += cost;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}