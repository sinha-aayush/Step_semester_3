package WEEK_7.Assignment_Problems;

public class q2 {
    private final boolean[] results;
    private int recordedCount;

    public q2(int totalQuestions) {
        this.results = new boolean[totalQuestions]; // Total number of questions is fixed[cite: 2]
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < results.length) {
            results[recordedCount] = isCorrect;
            recordedCount++;
        }
        // Trying to record more answers than fixed count is ignored[cite: 2]
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score; // Exposes only the total score, never the array[cite: 2]
    }

    public static void main(String[] args) {
        q2 sc = new q2(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        
        System.out.println("Total Score -> " + sc.getScore()); // Expected: 3
    }
}