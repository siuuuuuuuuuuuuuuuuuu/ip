import java.util.Scanner;

/**
 * Bobby is a simple chatbot that echoes user input until the user types "bye".
 */
public class Bobby {
    private static final String EXIT_COMMAND = "bye";

    public static void main(String[] args) {
        System.out.println("Hello! I'm Bobby\nHow can I help you?");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase(EXIT_COMMAND)) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                System.out.println(userInput);
            }
        }
        scanner.close();
    }
}
