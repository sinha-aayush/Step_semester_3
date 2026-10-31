package WEEK_9.Practice_Problems;

import java.util.Scanner;

abstract class Booking {
    String mode;
    double distance;
    static final double BOOKING_FEE = 50.0;
    
    Booking(String mode, double distance) {
        this.mode = mode;
        this.distance = distance;
    }
    
    abstract double calculateBaseFare();
    
    double getTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distance) {
        super("BUS", distance);
    }
    
    double calculateBaseFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends Booking {
    TrainBooking(double distance) {
        super("TRAIN", distance);
    }
    
    double calculateBaseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends Booking {
    FlightBooking(double distance) {
        super("FLIGHT", distance);
    }
    
    double calculateBaseFare() {
        return 2500.0 + (distance * 4.0);
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()){ sc.close(); return;}
        int n = sc.nextInt();
        Booking[] bookings = new Booking[n];
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            if (mode.equals("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else if (mode.equals("FLIGHT")) {
                bookings[i] = new FlightBooking(distance);
            }
        }
        for (Booking b : bookings) {
            System.out.printf("%s: %.2f\n", b.mode, b.getTotal());
        }
        sc.close();
    }
}
