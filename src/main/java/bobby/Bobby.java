package bobby;

import bobby.command.Command;

/**
 * Main class for the Bobby task manager application.
 * Handles initialization, command loop, and program entry point.
 */
public class Bobby {
    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

    /**
     * Constructs a Bobby instance, loading tasks from the specified file path.
     * If loading fails, initializes with an empty task list.
     *
     * @param filePath Path to the file storing tasks.
     */
    public Bobby(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTasks());
        } catch (Exception e) {
            ui.showLoadingError(e.getMessage());
            tasks = new TaskList();
        }
    }

    /**
     * Runs the main command loop, reading and executing user commands until exit.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command command = Parser.parse(fullCommand);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (BobbyException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showError("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Entry point for the Bobby application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Bobby("data/tasks.txt").run();
    }
}
