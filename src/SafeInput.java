
import java.util.Scanner;

public class SafeInput {

    // Get an integer within a specified range
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {

        int number;

        do {
            System.out.print(prompt);

            while (!console.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                console.nextLine();
                System.out.print(prompt);
            }

            number = console.nextInt();
            console.nextLine();

            if (number < low || number > high) {
                System.out.println("Please enter a number between " + low + " and " + high + ".");
            }

        } while (number < low || number > high);

        return number;
    }

    // Ask the user a yes or no question
    public static boolean getYNConfirm(Scanner console, String prompt) {

        String answer;

        do {
            System.out.print(prompt);
            answer = console.nextLine().trim();

            if (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")) {
                System.out.println("Please enter Y or N.");
            }

        } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));

        return answer.equalsIgnoreCase("Y");
    }
}
