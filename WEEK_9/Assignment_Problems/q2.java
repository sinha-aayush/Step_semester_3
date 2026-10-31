package WEEK_9.Assignment_Problems;

import java.util.Scanner;

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();
}

interface Insurable {
    double calculateInsurance(double declaredValue);
}

class Standard extends Parcel {
    Standard(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel = null;

            switch (type) {
                case "STANDARD":
                    parcel = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcel = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcel = new Fragile(weight, value);
                    break;
            }

            double charge = parcel.calculateCharge();
            double insurance = 0;

            if (parcel instanceof Insurable) {
                insurance = ((Insurable) parcel).calculateInsurance(value);
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}