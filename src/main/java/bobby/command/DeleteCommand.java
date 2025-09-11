package bobby;

public class DeleteCommand extends Command {
    private final int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws BobbyException {
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new BobbyException("Whatdatmean thats not a task number fam choose a number from 1 to " + tasks.size());
        }
        Task removed = tasks.delete(taskIndex);
        ui.showTaskDeleted(removed, tasks.size());
        try {
            storage.saveTasks(tasks.getAll());
        } catch (Exception e) {
            ui.showError("Failed to save tasks fam: " + e.getMessage());
        }
    }
}
