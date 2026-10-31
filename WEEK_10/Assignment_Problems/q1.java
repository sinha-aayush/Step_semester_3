package WEEK_10.Practice_Problems;

import java.util.Scanner;

// Abstract base class demonstrating encapsulation
abstract class Plot {
    private final String owner;
    private final String shape;

    protected Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }

    public String getOwner() { return owner; }
    public String getShape() { return shape; }
    
    // Abstract method to be overridden by subclasses
    public abstract double getArea();
}

class CirclePlot extends Plot {
    private final double radius;

    public CirclePlot(String owner, double radius) {
        super(owner, "CIRCLE");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    private final double length;
    private final double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner, "RECTANGLE");
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    private final double base;
    private final double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner, "TRIANGLE");
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Robust check for initial integer input
        if (!sc.hasNextInt()) {
            System.out.println("Invalid Input: Expected total number of plots.");
            sc.close();
            return;
        }
        
        int n = sc.nextInt();
        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String shape = sc.next().toUpperCase(); // Handle case insensitivity gracefully
            String owner = sc.next();

            switch (shape) {
                case "CIRCLE":
                    double radius = sc.nextDouble();
                    plots[i] = new CirclePlot(owner, radius);
                    break;
                case "RECTANGLE":
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();
                    plots[i] = new RectanglePlot(owner, length, width);
                    break;
                case "TRIANGLE":
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    plots[i] = new TrianglePlot(owner, base, height);
                    break;
                default:
                    System.out.println("Unknown shape type encountered: " + shape);
                    break;
            }
        }

        double totalArea = 0;
        System.out.println("\n--- Plot Processing Results ---");
        for (Plot p : plots) {
            if (p != null) { // Safeguard against uninitialized array indices
                double area = p.getArea();
                totalArea += area;
                System.out.printf("%s (%s): %.2f\n", p.getOwner(), p.getShape(), area);
            }
        }
        
        System.out.printf("Total Area: %.2f\n", totalArea);
        sc.close();
    }
}
