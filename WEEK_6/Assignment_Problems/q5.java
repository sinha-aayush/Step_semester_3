package WEEK_6.Assignment_Problems;

class Employee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class q5 {
    public static void main(String[] args) {
        Employee e1 = new Employee("Divya", 65000.0);
        Employee e2 = new Employee("Arjun", 30000.0);
        Employee e3 = new Employee("Rohan", 45000.0);

        Employee.printCompanyInfo();
    }
}