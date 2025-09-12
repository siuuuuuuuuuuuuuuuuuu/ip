package bobby.command;

import bobby.*;

/**
 * Command to exit the Bobby application.
 */
public class ExitCommand extends Command {
    /**
     * Executes the exit command, displaying a farewell message.
     *
     * @param tasks The current list of tasks.
     * @param ui The user interface for displaying messages.
     * @param storage The storage handler (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showLine();
        System.out.println("Goodbye! Have a great day.");
    }

    /**
     * Returns true to indicate that this command will exit the application.
     *
     * @return true, since this is the exit command.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
