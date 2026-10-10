package WEEK_8.Assignment_Problems;

import java.util.Scanner;

abstract class Customer {
    protected double amount;

    public Customer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
}

class Student extends Customer {
    public Student(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount - (amount * 0.10);
    }
}

class Staff extends Customer {
    public Staff(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount - (amount * 0.05);
    }
}

class Guest extends Customer {
    public Guest(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10;
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Customer[] customers = new Customer[n];
        
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amt = scanner.nextDouble();
            if (type.equals("STUDENT")) {
                customers[i] = new Student(amt);
            } else if (type.equals("STAFF")) {
                customers[i] = new Staff(amt);
            } else if (type.equals("GUEST")) {
                customers[i] = new Guest(amt);
            }
        }
        
        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double finalAmt = customers[i].calculateFinalAmount();
            grandTotal += finalAmt;
            String typeName = "";
            if (customers[i] instanceof Student) typeName = "STUDENT";
            else if (customers[i] instanceof Staff) typeName = "STAFF";
            else if (customers[i] instanceof Guest) typeName = "GUEST";
            
            System.out.printf("%s: %.2f\n", typeName, finalAmt);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}