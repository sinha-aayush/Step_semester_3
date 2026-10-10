package WEEK_8.Practice_Problems;

import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance); // Base $2, $0.10/km[cite: 25]
        return Math.min(fare, 10.0); // Max fare $10[cite: 25]
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance); // Base $3, $0.15/km[cite: 25]
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor; // Base $1.50, $0.20/km multiplied by peak factor[cite: 25]
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Transport[] transports = new Transport[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            types[i] = scanner.next();
            double distance = scanner.nextDouble();
            if (types[i].equals("BUS")) {
                transports[i] = new Bus(distance);
            } else if (types[i].equals("TRAIN")) {
                transports[i] = new Train(distance);
            } else if (types[i].equals("METRO")) {
                double peakFactor = scanner.nextDouble();
                transports[i] = new Metro(distance, peakFactor);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double fare = transports[i].calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f\n", types[i], fare);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}