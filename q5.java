package WEEK_1;
import java.util.Scanner;

class MovieReviewWordProfiler {

    public static void classifyWordLengths(String review) {

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        // Split the review into words
        String[] words = review.split("\\s+");

        // Check each word
        for (int i = 0; i < words.length; i++) {

            int length = words[i].length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } 
            else if (length >= 5 && length <= 8) {
                mediumCount++;
            } 
            else if (length >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount);
        System.out.println("Medium: " + mediumCount);
        System.out.println("Long: " + longCount);
    }
}

public class q5{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        MovieReviewWordProfiler.classifyWordLengths(review);

        sc.close();
    }
}