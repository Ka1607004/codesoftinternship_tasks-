import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean wonRound = false;
            roundsPlayed++;

            System.out.println("\nRound " + roundsPlayed);
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    continue;
                }
                
                attempts++;
                
                if (guess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    roundsWon++;
                    wonRound = true;
                    break;
                } else if (guess < generatedNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                
                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!wonRound) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + generatedNumber + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over");
        System.out.println("Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Score: " + roundsWon + " out of " + roundsPlayed + " rounds");

        scanner.close();
    }
}
