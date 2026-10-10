package WEEK_8.Assignment_Problems;

import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8;
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class AcRoom extends Room {
    public AcRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10) + 200;
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Room[] rooms = new Room[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            types[i] = scanner.next();
            int units = scanner.nextInt();
            if (types[i].equals("SINGLE")) {
                rooms[i] = new SingleRoom(units);
            } else if (types[i].equals("SHARED")) {
                int occupants = scanner.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            } else if (types[i].equals("AC")) {
                rooms[i] = new AcRoom(units);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double bill = rooms[i].calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f\n", types[i], bill);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}