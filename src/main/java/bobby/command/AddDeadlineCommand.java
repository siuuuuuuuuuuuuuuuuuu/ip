package bobby.command;

import bobby.bobbyexception.BobbyException;
import bobby.task.Deadline;
import bobby.storage.Storage;
import bobby.task.Task;
import bobby.task.TaskList;
import bobby.ui.Ui;

/**
 * Command to add a new deadline task to the task list.
 */
public class AddDeadlineCommand extends Command {
    private final String description;
    private final String by;

    /**
     * Constructs an AddDeadlineCommand with the specified description and deadline.
     *
     * @param description Description of the deadline task to add.
     * @param by Deadline date as a string.
     */
    public AddDeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Executes the add deadline command, adding the new task and saving changes.
     *
     * @param tasks The current list of tasks.
     * @param ui The user interface for displaying messages.
     * @param storage The storage handler for saving tasks.
     * @throws BobbyException If an error occurs during task creation.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws BobbyException {
        Task deadline = new Deadline(description, by);
        tasks.add(deadline);
        StringBuilder response = new StringBuilder();
        response.append("Added: ").append(deadline.toString()).append(System.lineSeparator());
        response.append("Now you have ").append(tasks.size()).append(" tasks in the list.");
        try {
            storage.saveTasks(tasks.getAll());
        } catch (Exception e) {
            response.append(System.lineSeparator())
                    .append("Failed to save tasks fam: ").append(e.getMessage());
        }
        return response.toString();
    }
}
