package WEEK_10.Practice_Problems;

import java.util.Scanner;

abstract class Connection {
    String typeName;
    int units;
    
    Connection(String typeName, int units) {
        this.typeName = typeName;
        this.units = units;
    }
    
    abstract double getBill();
}

class HomeConnection extends Connection {
    HomeConnection(int units) {
        super("HOME", units);
    }
    
    double getBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class ShopConnection extends Connection {
    ShopConnection(int units) {
        super("SHOP", units);
    }
    
    double getBill() {
        return (units * 8.0) + 100.0;
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(int units) {
        super("FACTORY", units);
    }
    
    double getBill() {
        double bill = units * 6.0;
        return bill < 1000.0 ? 1000.0 : bill;
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()){ sc.close(); return;}
        int n = sc.nextInt();
        Connection[] connections = new Connection[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            if (type.equals("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else if (type.equals("FACTORY")) {
                connections[i] = new FactoryConnection(units);
            }
        }
        double total = 0;
        for (Connection c : connections) {
            double bill = c.getBill();
            total += bill;
            System.out.printf("%s: %.2f\n", c.typeName, bill);
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}
