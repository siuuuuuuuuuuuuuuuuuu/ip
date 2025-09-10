import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Hi im Bobby\nHow can I help you");
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showLine() {
        System.out.println("_________");
    }

    public void showLoadingError(String message) {
        System.out.println("error loading tasks gg: " + message);
    }

    public void showError(String message) {
        System.out.println("got error gg: " + message);
    }
}
