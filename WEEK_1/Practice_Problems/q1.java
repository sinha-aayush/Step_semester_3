package Practice_Problems;

import java.util.Random;
import java.util.Scanner;

public class q1 {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final Random random = new Random();

    public static String getRandomComputerMove() {
        return MOVES[random.nextInt(3)];
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        } else {
            return "Computer Wins";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = 5;
        
        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.print("Round " + (i + 1) + " - Enter move (Rock, Paper, Scissors): ");
            playerMoves[i] = scanner.nextLine().trim();
            computerMoves[i] = getRandomComputerMove();
            
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        // Summary Table
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-8s | %-12s | %-13s | %-12s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-------------------------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d | %-12s | %-13s | %-12s\n", (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("-------------------------------------------------------------");

        double winPercentage = ((double) wins / rounds) * 100;
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
        
        scanner.close();
    }
}
