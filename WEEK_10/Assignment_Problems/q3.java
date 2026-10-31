package WEEK_10.Assignment_Problems;

import java.util.Arrays;

public class q3 {
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int effectiveK = (int) (k % n);
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            int newIndex = (i + effectiveK) % n;
            rotated[newIndex] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        long k = 2;
        String[] result = rotateRoster(names, k);
        System.out.println(Arrays.toString(result));
    }
}