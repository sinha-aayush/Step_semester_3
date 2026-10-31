package WEEK_10.Assignment_Problems;

import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String word = sc.next();

            StringBuilder sb = new StringBuilder(word);
            String reverse = sb.reverse().toString();

            if (word.equals(reverse)) {
                System.out.println(reverse + " - palindrome");
            } else {
                System.out.println(reverse + " - not a palindrome");
            }
        }

        sc.close();
    }
}