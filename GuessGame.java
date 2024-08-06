import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalScore = 0;
        boolean playAgain;

        do {
            int guess = (int) (Math.random() * 100) + 1;
            int maxLives = 3;
            int attempts = 0;

            System.out.println("Guess the number between 1-100:");

            do {
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == guess) {
                    System.out.println("Correct!");
                    System.out.printf("You took %d attempts.\n", attempts);```
                    totalScore += attempts;
                    break;
                } else if (--maxLives == 0) {
                    System.out.println("You lose! The number was: " + guess);
                    break;
                } else if (userGuess > guess) {
                    System.out.println("Too high. Lives left: " + maxLives);
                } else {
                    System.out.println("Too low. Lives left: " + maxLives);
                }
            } while (true);

            System.out.print("Play again? (yes/no): ");
            String playChoice = sc.next();
            playAgain = playChoice.equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Game over. Your total score is: " + totalScore);
        sc.close();
    }
}
