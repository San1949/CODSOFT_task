package pack1;
import java.util.*;

public class Task1 {

    public static String stars(int score) {
        int starCount = score / 10; 
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < starCount; i++) {
            sb.append("★");
        }
        if (sb.length() == 0) return "No Stars!";
        return sb.toString();
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        String play1 = "yes";

        System.out.println("TASK 1\n");
        System.out.println("                          NUMBER GAME                               \n");

        while (play1.equalsIgnoreCase("yes")) {

            // IMPORTANT: RESET for each new game
            int score = 100;
            int attempt = 0;
            int hideno = rnd.nextInt(100) + 1;

            System.out.println("Guess the number between 1 and 100. Type 0 to give up!\n");
            System.out.println("+------------------------+-----------------------+--------------------+");
            System.out.println("|    ATTEMPT NUMBER     |          GUESS        |        RESULT      |");
            System.out.println("+------------------------+-----------------------+--------------------+");

            while (true) {

                System.out.println("Enter number:");

                if (!scan.hasNextInt()) {
                    System.out.println("Please enter an integer!");
                    scan.next(); 
                    continue;
                }

                int guessno = scan.nextInt();
                attempt++;

                if (guessno == 0) {
                    System.out.printf("| %-22d | %-21d | %-18s |\n", attempt, guessno, "Wrong");
                    System.out.println("Secret Number : " + hideno);
                    System.out.println("Attempt      : " + attempt);
                    System.out.println("Score        : 0");
                    break;
                }

                if (guessno == hideno) {
                    System.out.printf("| %-22d | %-21d | %-18s |\n", attempt, guessno, "Correct");
                    System.out.println("+------------------------+-----------------------+--------------------+\n");
                    System.out.println("YOU WON THE GAME");
                    System.out.println("Secret Number : " + hideno);
                    System.out.println("Attempt      : " + attempt);
                    System.out.println("Your Score   : " + stars(score));
                    break;
                } 
                else if (guessno < hideno) {
                    System.out.printf("| %-22d | %-21d | %-18s |\n", attempt, guessno, "Too Low");
                    score -= 10;
                } 
                else {
                    System.out.printf("| %-22d | %-21d | %-18s |\n", attempt, guessno, "Too High");
                    score -= 10;
                }

                if (score <= 0) {
                    System.out.println("+----------------+----------------------+-------------------+");
                    System.out.println("Score reached zero! You lost.");
                    System.out.println("Secret Number : " + hideno);
                    System.out.println("Attempt      : " + attempt);
                    System.out.println("Score        : " + stars(0));
                    break;
                }
            }

            System.out.println("Do you want to play again(yes/no):");
            
            scan.nextLine();          // clear leftover newline
            play1 = scan.nextLine();  // read actual input
        }

        System.out.println("Thanks for playing");
    }
}
