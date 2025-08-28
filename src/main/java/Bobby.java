import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bobby is a simple chatbot that echoes user input until the user types "bye".
 */
public class Bobby {
    private static final String EXIT_COMMAND = "bye";
    private static final String LIST_COMMAND = "list";

    public static void main(String[] args) {
        System.out.println("Hello! I'm Bobby\nHow can I help you?");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> commands = new ArrayList<>();

        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase(EXIT_COMMAND)) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (userInput.equalsIgnoreCase(LIST_COMMAND)) {
                for (int i = 0; i < commands.size(); i++) {
                    System.out.println((i + 1) + ". " + commands.get(i));
                }
            }
            else {
                commands.add(userInput);
                System.out.println("added: " + userInput);
            }
        }
        scanner.close();
    }
}
