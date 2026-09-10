import java.util.Scanner;

public class InputValidator {

    public static int getInt(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }

            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    public static int getIntInRange(
            Scanner scanner,
            String message,
            int min,
            int max) {

        while (true) {

            int value = getInt(scanner, message);

            if (value >= min && value <= max) {
                return value;
            }

            System.out.println(
                "Please enter a value between "
                + min + " and " + max + "."
            );
        }
    }

    public static String getNonEmptyString(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                "Input cannot be empty."
            );
        }
    }
}