package bobby;

import bobby.command.Command;

public class Bobby {
    private final Storage storage;
    private TaskList tasks;
    private final Ui ui;

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

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (BobbyException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showError("got error bro shag: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Bobby("data/tasks.txt").run();
    }
}
