package WEEK_7.Assignment_Problems;

public class q1 {
    private final String id;
    private double savings;

    public q1(String id) {
        this.id = id;
        this.savings = 0.0; // A new piggy bank starts at 0 savings[cite: 1]
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount; // Depositing adds exactly that amount[cite: 1]
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
        }
        // Withdrawing more than saved leaves the amount unchanged[cite: 1]
    }

    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        q1 pb = new q1("PB-1");
        
        pb.deposit(100);
        System.out.println("After depositing 100, savings = " + pb.getSavings()); // Expected: 100
        
        pb.withdraw(30);
        System.out.println("After withdrawing 30, savings = " + pb.getSavings()); // Expected: 70
        
        pb.withdraw(500);
        System.out.println("After withdrawing 500 (rejected), savings = " + pb.getSavings()); // Expected: 70
    }
}