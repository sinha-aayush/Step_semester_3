package WEEK_10.Assignment_Problems;

import java.util.Scanner;
import java.math.BigInteger;

public class q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            BigInteger fact = BigInteger.ONE;

            for (int i = 1; i <= n; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }

            System.out.println(fact);
        }

        sc.close();
    }
}