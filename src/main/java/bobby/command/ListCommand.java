package bobby.command;

import bobby.Storage;
import bobby.TaskList;
import bobby.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showTaskList(tasks.getAll());
    }
}
