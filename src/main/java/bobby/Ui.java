package bobby;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles user interaction by displaying messages and reading input from the console.
 */
public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Displays the welcome message to the user.
     */
    public void showWelcome() {
        System.out.println("Hi Im Bobby\nWhat can I do for you?");
    }

    /**
     * Displays an error message to the user.
     *
     * @param msg The error message to display.
     */
    public void showError(String msg) {
        System.out.println("Error: " + msg);
    }

    /**
     * Displays a message indicating a task has been marked as done.
     *
     * @param task The task that was marked as done.
     */
    public void showTaskMarkedDone(Task task) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + task);
    }

    /**
     * Displays a message indicating a task has been added.
     *
     * @param task The task that was added.
     * @param size The new size of the task list.
     */
    public void showTaskAdded(Task task, int size) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * Displays a message indicating a task has been deleted.
     *
     * @param task The task that was deleted.
     * @param size The new size of the task list.
     */
    public void showTaskDeleted(Task task, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    /**
     * Displays the list of all tasks.
     *
     * @param tasks The list of tasks to display.
     */
    public void showTaskList(ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    /**
     * Displays the list of found tasks matching a search keyword.
     *
     * @param tasks The list of matching tasks to display.
     */
    public void showFoundTasks(ArrayList<Task> tasks) {
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    /**
     * Displays a separator line.
     */
    public void showLine() {
        System.out.println("____________________________");
    }

    /**
     * Reads the next command from the user input.
     *
     * @return The command string entered by the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays an error message when loading tasks fails.
     *
     * @param msg The error message to display.
     */
    public void showLoadingError(String msg) {
        System.out.println("Error loading tasks: " + msg);
    }
}
