package bobby.command;

import bobby.*;

/**
 * Command to add a new todo task to the task list.
 */
public class AddTodoCommand extends Command {
    private final String description;

    /**
     * Constructs an AddTodoCommand with the specified task description.
     *
     * @param description Description of the todo task to add.
     */
    public AddTodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the add todo command, adding the new task and saving changes.
     *
     * @param tasks The current list of tasks.
     * @param ui The user interface for displaying messages.
     * @param storage The storage handler for saving tasks.
     * @throws BobbyException If an error occurs during task creation.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws BobbyException {
        Task todo = new ToDo(description);
        tasks.add(todo);
        ui.showTaskAdded(todo, tasks.size());
        try {
            storage.saveTasks(tasks.getAll());
        } catch (Exception e) {
            ui.showError("Failed to save tasks fam: " + e.getMessage());
        }
    }
}
