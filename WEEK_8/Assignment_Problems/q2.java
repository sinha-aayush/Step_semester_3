package WEEK_8.Assignment_Problems;

import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        if (hours == 1) {
            return 30;
        }
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        double charge = hours * 50;
        return Math.max(charge, 100);
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Vehicle[] vehicles = new Vehicle[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            types[i] = scanner.next();
            int hrs = scanner.nextInt();
            if (types[i].equals("BIKE")) {
                vehicles[i] = new Bike(hrs);
            } else if (types[i].equals("CAR")) {
                vehicles[i] = new Car(hrs);
            } else if (types[i].equals("TRUCK")) {
                vehicles[i] = new Truck(hrs);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double charge = vehicles[i].calculateCharge();
            grandTotal += charge;
            System.out.printf("%s: %.2f\n", types[i], charge);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}