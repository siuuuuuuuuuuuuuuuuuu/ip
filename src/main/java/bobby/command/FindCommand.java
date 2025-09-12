package bobby.command;

import java.util.ArrayList;
import bobby.Storage;
import bobby.Task;
import bobby.TaskList;
import bobby.Ui;

/**
 * Command to find and display tasks matching a keyword.
 */
public class FindCommand extends Command {
    private final String keyword;

    /**
     * Constructs a FindCommand with the specified search keyword.
     *
     * @param keyword The keyword to search for in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command, displaying tasks that match the keyword.
     *
     * @param tasks The current list of tasks.
     * @param ui The user interface for displaying messages.
     * @param storage The storage handler (not used in this command).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> found = tasks.find(keyword);
        ui.showFoundTasks(found);
    }
}
