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
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase(EXIT_COMMAND)) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (userInput.equalsIgnoreCase(LIST_COMMAND)) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < tasks.size(); i++) {
                    Task t = tasks.get(i);
                    System.out.println((i + 1) + ". " + t.getStatus() + " " + t.getDescription());
                }
            } else if (userInput.startsWith("mark ")) {
                try {
                    int index = Integer.parseInt(userInput.substring(5).trim()) - 1;
                    if (index >= 0 && index < tasks.size()) {
                        tasks.get(index).mark();
                        System.out.println("Nice! I've marked this task as done:\n" + "  " + tasks.get(index).getStatus() + " " + tasks.get(index).getDescription());
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please provide a valid task number to mark.");
                }
            } else if (userInput.startsWith("unmark ")) {
                try {
                    int index = Integer.parseInt(userInput.substring(7).trim()) - 1;
                    if (index >= 0 && index < tasks.size()) {
                        tasks.get(index).unmark();
                        System.out.println("OK, I've marked this task as not done yet:\n" + "  " + tasks.get(index).getStatus() + " " + tasks.get(index).getDescription());
                    } else {
                        System.out.println("Invalid task number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please provide a valid task number to unmark.");
                }
            }
            else if (!userInput.isEmpty()) {
                tasks.add(new Task(userInput));
                System.out.println("added: " + userInput);
            }
        }
        scanner.close();
    }
}
