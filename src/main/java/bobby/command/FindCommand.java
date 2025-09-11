package bobby.command;

import java.util.ArrayList;
import bobby.Storage;
import bobby.Task;
import bobby.TaskList;
import bobby.Ui;

public class FindCommand extends Command {
    private final String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> found = tasks.find(keyword);
        ui.showFoundTasks(found);
    }
}
