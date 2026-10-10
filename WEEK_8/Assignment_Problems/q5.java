package WEEK_8.Assignment_Problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscriber {
    protected String name;
    protected LocalDate startDate;

    public Subscriber(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract LocalDate calculateRenewalDate();
    public String getName() { return name; }
}

class BasicSubscriber extends Subscriber {
    public BasicSubscriber(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardSubscriber extends Subscriber {
    public StandardSubscriber(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumSubscriber extends Subscriber {
    public PremiumSubscriber(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Subscriber[] subscribers = new Subscriber[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());
            if (type.equals("BASIC")) {
                subscribers[i] = new BasicSubscriber(name, startDate);
            } else if (type.equals("STANDARD")) {
                subscribers[i] = new StandardSubscriber(name, startDate);
            } else if (type.equals("PREMIUM")) {
                subscribers[i] = new PremiumSubscriber(name, startDate);
            }
        }

        for (int i = 0; i < n; i++) {
            LocalDate renewalDate = subscribers[i].calculateRenewalDate();
            System.out.println(subscribers[i].getName() + ": " + renewalDate);
        }
        scanner.close();
    }
}