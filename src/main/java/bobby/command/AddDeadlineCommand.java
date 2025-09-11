package bobby;

public class AddDeadlineCommand extends Command {
    private final String description;
    private final String by;

    public AddDeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws BobbyException {
        Task deadline = new Deadline(description, by);
        tasks.add(deadline);
        ui.showTaskAdded(deadline, tasks.size());
        try {
            storage.saveTasks(tasks.getAll());
        } catch (Exception e) {
            ui.showError("Failed to save tasks fam: " + e.getMessage());
        }
    }
}
