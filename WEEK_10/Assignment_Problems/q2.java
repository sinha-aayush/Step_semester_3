package WEEK_10.Practice_Problems;

import java.util.Scanner;

abstract class Staff {
    String name;
    
    Staff(String name) {
        this.name = name;
    }
    
    abstract double getPay();
}

class FullTimeStaff extends Staff {
    double salary;
    
    FullTimeStaff(String name, double salary) {
        super(name);
        this.salary = salary;
    }
    
    double getPay() {
        return salary;
    }
}

class HourlyStaff extends Staff {
    int hours;
    double rate;
    
    HourlyStaff(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    
    double getPay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class InternStaff extends Staff {
    double stipend;
    
    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    
    double getPay() {
        return stipend;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()){ sc.close(); return;}
        int n = sc.nextInt();
        Staff[] staffList = new Staff[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if (type.equals("FULLTIME")) {
                double salary = sc.nextDouble();
                staffList[i] = new FullTimeStaff(name, salary);
            } else if (type.equals("HOURLY")) {
                int hours = sc.nextInt();
                double rate = sc.nextDouble();
                staffList[i] = new HourlyStaff(name, hours, rate);
            } else if (type.equals("INTERN")) {
                double stipend = sc.nextDouble();
                staffList[i] = new InternStaff(name, stipend);
            }
        }
        double totalPayroll = 0;
        for (Staff s : staffList) {
            double pay = s.getPay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f\n", s.name, pay);
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
        sc.close();
    }
}