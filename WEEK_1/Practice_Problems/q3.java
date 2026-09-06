package Practice_Problems;

import java.util.Random;

public class q3 {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s | %-11s | %-11s | %-8s | %-12s\n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %-3d | %-11.2f | %-11.2f | %-8.2f | %-12s\n", (i + 1), heights[i], weights[i], bmi, status);
        }
        System.out.println("-------------------------------------------------------------");
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        
        Random random = new Random();

        // Generating random heights (1.50m - 1.90m) and weights (50kg - 100kg)
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + (1.90 - 1.50) * random.nextDouble();
            weights[i] = 50.0 + (100.0 - 50.0) * random.nextDouble();
        }

        printWellnessReport(heights, weights);
    }
}

