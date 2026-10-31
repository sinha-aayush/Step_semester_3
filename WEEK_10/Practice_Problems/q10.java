package WEEK_10.Practice_Problems;

import java.util.Scanner;
import java.util.Locale;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return sum / 3.0;
    }

    char calculateGrade() {
        double avg = calculateAverage();

        if (avg >= 90) {
            return 'A';
        } else if (avg >= 75) {
            return 'B';
        } else if (avg >= 60) {
            return 'C';
        } else if (avg >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void display() {
        System.out.printf(
            Locale.US,
            "%s: Average %.1f, Grade %c%n",
            name.toUpperCase(),
            calculateAverage(),
            calculateGrade()
        );
    }
}

public class q10
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String name = sc.next();
            int[] marks = new int[3];

            for (int i = 0; i < 3; i++) {
                String value = sc.next();

                value = value.replace("[", "")
                             .replace("]", "")
                             .replace(",", "");

                marks[i] = Integer.parseInt(value);
            }

            Student student = new Student(name, marks);
            student.display();
        }

        sc.close();
    }
}