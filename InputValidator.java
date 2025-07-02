import java.util.Scanner;

public class InputValidator {
    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
            return getUserInput(); // Recursive call
        }
    }
}
