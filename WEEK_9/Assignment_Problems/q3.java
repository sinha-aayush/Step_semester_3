package WEEK_9.Assignment_Problems;

import java.util.Scanner;

abstract class Student {
    protected String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    double calculateFee() {
        double fee = calculateTuition();

        if (this instanceof BusUser) {
            fee += BusUser.TRANSPORT_FEE;
        }

        return fee;
    }
}

interface BusUser {
    double TRANSPORT_FEE = 12000;
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }
}

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student = null;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
            }

            double fee = student.calculateFee();
            total += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}