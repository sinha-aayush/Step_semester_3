package WEEK_6.Assignment_Problems;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Setting basic salary to 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0.0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Credit bonus rejected: Amount must be greater than 0");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Deduct tax rejected: Invalid percentage");
        } else {
            this.basicSalary -= (this.basicSalary * percent / 100.0);
            System.out.println("Tax % deducted: " + (int) percent);
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class q2 {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000.0);

        account.creditBonus(5000.0);
        account.deductTax(10.0);

        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}