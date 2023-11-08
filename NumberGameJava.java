import java.util.Random;
import java.util.Scanner;

public class NumberGameJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 5;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Game!");
        System.out.println("You have " + numberOfAttempts + " attempts to guess the number between " + minRange + " and " + maxRange);

        while (true) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            while (attempts < numberOfAttempts) {
                try {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts.");
                        roundsWon++;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Try a higher number. Attempts left: " + (numberOfAttempts - attempts));
                    } else {
                        System.out.println("Try a lower number. Attempts left: " + (numberOfAttempts - attempts));
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume the invalid input
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thank you for playing. You won " + roundsWon + " round(s)!");
                break;
            }
        }

        scanner.close();
    }
}
