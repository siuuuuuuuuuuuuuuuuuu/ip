package bobby;

public class DoneCommand extends Command {
    private final int taskIndex;

    public DoneCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

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
