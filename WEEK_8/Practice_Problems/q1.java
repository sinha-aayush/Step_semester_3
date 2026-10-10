package WEEK_8.Practice_Problems;

import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateAdjustedAmount();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount + (amount * 0.02); // 2% processing fee[cite: 21]
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount + (amount * 0.01); // 1% processing fee[cite: 21]
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return amount; // No processing fee[cite: 21]
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Payment[] payments = new Payment[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            types[i] = scanner.next();
            double amt = scanner.nextDouble();
            if (types[i].equals("CARD")) {
                payments[i] = new CardPayment(amt);
            } else if (types[i].equals("WALLET")) {
                payments[i] = new WalletPayment(amt);
            } else if (types[i].equals("BANKTRANSFER")) {
                payments[i] = new BankTransferPayment(amt);
            }
        }

        double grandTotal = 0.0;
        for (int i = 0; i < n; i++) {
            double adjusted = payments[i].calculateAdjustedAmount();
            grandTotal += adjusted;
            System.out.printf("%s: %.2f\n", types[i], adjusted);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        scanner.close();
    }
}