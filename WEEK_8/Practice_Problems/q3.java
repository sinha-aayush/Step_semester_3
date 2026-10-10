package WEEK_8.Practice_Problems;

import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * weight) + (0.10 * distance); // Base $5, $0.50/kg, $0.10/km[cite: 23]
    }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * weight) + (0.20 * distance); // Base $15, $1.00/kg, $0.20/km[cite: 23]
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee; // Base $25, $2.00/kg, $0.50/km + customs[cite: 23]
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Delivery[] deliveries = new Delivery[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            types[i] = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            if (types[i].equals("STANDARD")) {
                deliveries[i] = new StandardDelivery(weight, distance);
            } else if (types[i].equals("EXPRESS")) {
                deliveries[i] = new ExpressDelivery(weight, distance);
            } else if (types[i].equals("INTERNATIONAL")) {
                double customsFee = scanner.nextDouble();
                deliveries[i] = new InternationalDelivery(weight, distance, customsFee);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double fee = deliveries[i].calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f\n", types[i], fee);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}