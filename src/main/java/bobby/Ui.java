package bobby;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private final Scanner scanner = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("hi im Bobby\nWhat can I do for you today?");
    }

    public void showError(String msg) {
        System.out.println("Error: " + msg);
    }

    public void showTaskMarkedDone(Task task) {
        System.out.println("Task marked as done:");
        System.out.println("  " + task);
    }

    public void showTaskAdded(Task task, int size) {
        System.out.println("Task added:");
        System.out.println("  " + task);
        System.out.println("You now have " + size + " tasks in the list.");
    }

    public void showTaskDeleted(Task task, int size) {
        System.out.println("Task removed:");
        System.out.println("  " + task);
        System.out.println("You now have " + size + " tasks in the list.");
    }

    public void showTaskList(ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void showFoundTasks(ArrayList<Task> tasks) {
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void showLine() {
        System.out.println("____________________________");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLoadingError(String msg) {
        System.out.println("Error loading tasks: " + msg);
    }
}
