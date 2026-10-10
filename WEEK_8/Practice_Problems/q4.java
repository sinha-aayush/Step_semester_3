package WEEK_8.Practice_Problems;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double grade();
}

class McqQuestion extends Question {
    public McqQuestion(String text, String correct, String student, int points) {
        super(text, correct, student, points);
    }

    @Override
    public double grade() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0; //[cite: 24]
    }
}

class TfQuestion extends Question {
    public TfQuestion(String text, String correct, String student, int points) {
        super(text, correct, student, points);
    }

    @Override
    public double grade() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0; //[cite: 24]
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correct, String student, int points) {
        super(text, correct, student, points);
    }

    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        for (String kw : keywords) {
            String trimmedKw = kw.trim();
            if (!trimmedKw.isEmpty() && studentAnswer.toLowerCase().contains(trimmedKw.toLowerCase())) {
                matchCount++;
            }
        }
        if (matchCount >= 2) {
            return points * 0.75; //[cite: 24]
        } else if (matchCount == 1) {
            return points * 0.50; //[cite: 24]
        }
        return 0.0;
    }
}

public class q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        Question[] questions = new Question[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            types[i] = line.substring(0, firstSpace);
            String rest = line.substring(firstSpace + 1).trim();
            
            List<String> parts = new ArrayList<>();
            boolean inQuotes = false;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < rest.length(); j++) {
                char c = rest.charAt(j);
                if (c == '"') {
                    inQuotes = !inQuotes;
                } else if (c == ' ' && !inQuotes) {
                    parts.add(sb.toString().trim());
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                parts.add(sb.toString().trim());
            }
            
            String qText = parts.get(0);
            String correct = parts.get(1);
            String student = parts.get(2);
            int pts = Integer.parseInt(parts.get(3));
            
            if (types[i].equals("MCQ")) {
                questions[i] = new McqQuestion(qText, correct, student, pts);
            } else if (types[i].equals("TF")) {
                questions[i] = new TfQuestion(qText, correct, student, pts);
            } else if (types[i].equals("ESSAY")) {
                questions[i] = new EssayQuestion(qText, correct, student, pts);
            }
        }

        double overallScore = 0.0;
        for (int i = 0; i < n; i++) {
            double score = questions[i].grade();
            overallScore += score;
            System.out.printf("%s: %.2f\n", types[i], score);
        }
        System.out.printf("Total Score: %.2f\n", overallScore);
        scanner.close();
    }
}