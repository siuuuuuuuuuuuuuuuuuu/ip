import java.util.ArrayList;
import java.util.Scanner;

public class Bobby {
    private static final String EXIT_COMMAND = "bye";
    private static final String LIST_COMMAND = "list";

    public static void main(String[] args) {
        System.out.println("Hello! I'm Bobby\nHow can I help you?");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            try {
                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase(EXIT_COMMAND)) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                } else if (userInput.equalsIgnoreCase(LIST_COMMAND)) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < tasks.size(); i++) {
                        Task t = tasks.get(i);
                        System.out.println((i + 1) + ". " + t);
                    }
                } else if (userInput.startsWith("todo")) {
                    handleTodoCommand(userInput, tasks);
                } else if (userInput.startsWith("deadline")) {
                    handleDeadlineCommand(userInput, tasks);
                } else if (userInput.startsWith("event")) {
                    handleEventCommand(userInput, tasks);
                } else if (!userInput.isEmpty()) {
                    throw new BobbyException("Whatdatmean");
                }
            } catch (BobbyException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    private static void handleTodoCommand(String userInput, ArrayList<Task> tasks) throws BobbyException {
        String desc = userInput.length() > 4 ? userInput.substring(4).trim() : "";
        if (desc.isEmpty()) {
            throw new BobbyException("Whatdatmean the description is empty");
        }
        Task t = new ToDo(desc);
        tasks.add(t);
        System.out.println("Got it. I've added this task:\n  " + t);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    private static void handleDeadlineCommand(String userInput, ArrayList<Task> tasks) throws BobbyException {
        String[] parts = userInput.length() > 8 ? userInput.substring(8).split("/by", 2) : new String[0];
        if (parts.length != 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new BobbyException("Whatdatmean what time does the deadline start and end?");
        }
        String desc = parts[0].trim();
        String by = parts[1].trim();
        Task t = new Deadline(desc, by);
        tasks.add(t);
        System.out.println("Got it. I've added this task:\n  " + t);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    private static void handleEventCommand(String userInput, ArrayList<Task> tasks) throws BobbyException {
        String[] parts = userInput.length() > 5 ? userInput.substring(5).split("/from", 2) : new String[0];
        if (parts.length != 2 || parts[0].trim().isEmpty()) {
            throw new BobbyException("Whatdateventabout");
        }
        String desc = parts[0].trim();
        String[] timeParts = parts[1].split("/to", 2);
        if (timeParts.length != 2 || timeParts[0].trim().isEmpty() || timeParts[1].trim().isEmpty()) {
            throw new BobbyException("Whatdatmean what time does the event start and end?");
        }
        String from = timeParts[0].trim();
        String to = timeParts[1].trim();
        Task t = new Event(desc, from, to);
        tasks.add(t);
        System.out.println("Got it. I've added this task:\n  " + t);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }
}
