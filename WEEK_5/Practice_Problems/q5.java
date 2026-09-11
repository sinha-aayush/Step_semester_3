package WEEK_5.Practice_Problems;
import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.0 && codingScore >= 70;
    }

    public double getCompositeScore() {
        return (cgpa * 10) + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        java.util.List<Candidate> shortlisted = new java.util.ArrayList<>();
        
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }
        
        Candidate[] arr = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append((i + 1)).append(". ").append(arr[i].name)
              .append(" (").append(arr[i].getCompositeScore()).append(")");
        }
        return sb.toString();
    }
}

public class q5{
    public static void main(String[] args) {
    Candidate[] candidates = {
        new Candidate("Aisha", 8.2, 40),
        new Candidate("Rohit", 6.8, 65),
        new Candidate("Meena", 6.0, 90),
        new Candidate("Karan", 7.5, 20)
    };

    String result = Candidate.shortlistAndRank(candidates);

    System.out.println(result);
}

}
