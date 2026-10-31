package WEEK_10.Assignment_Problems;

import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        input = input.replace("[", "").replace("]", "").replace(",", "");

        String[] numbers = input.trim().split("\\s+");

        int even = 0, odd = 0;

        for (String num : numbers) {
            int n = Integer.parseInt(num);

            if (n % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);

        sc.close();
    }
}