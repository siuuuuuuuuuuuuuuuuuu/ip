package bobby.command;

import bobby.*;

/**
 * Command to mark a specific task as done.
 */
public class DoneCommand extends Command {
    private final int taskIndex;

    /**
     * Constructs a DoneCommand for the specified task index.
     *
     * @param taskIndex Index of the task to mark as done.
     */
    public DoneCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the done command, marking the specified task as done and saving changes.
     *
     * @param tasks The current list of tasks.
     * @param ui The user interface for displaying messages.
     * @param storage The storage handler for saving tasks.
     * @throws BobbyException If the task index is invalid.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws BobbyException {
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new BobbyException("Whatdatmean thats not a task number fam choose a number from 1 to " + tasks.size());
        }
        Task task = tasks.get(taskIndex);
        task.markAsDone();
        ui.showTaskMarkedDone(task);
        try {
            storage.saveTasks(tasks.getAll());
        } catch (Exception e) {
            ui.showError("Failed to save tasks: " + e.getMessage());
        }
    }
}
