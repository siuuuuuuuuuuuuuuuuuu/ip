package bobby.command;

import bobby.Storage;
import bobby.TaskList;
import bobby.Ui;

/**
 * Command to display the list of all tasks to the user.
 */
public class ListCommand extends Command {
    /**
     * Executes the list command, showing all tasks.
     *
     * @param tasks The current list of tasks.
     * @param ui The user interface for displaying messages.
     * @param storage The storage handler (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks.getAll());
    }
}
