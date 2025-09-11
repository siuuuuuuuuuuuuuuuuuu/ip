package bobby.command;

import bobby.BobbyException;
import bobby.Storage;
import bobby.TaskList;
import bobby.Ui;

public abstract class Command {
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws BobbyException;
    public boolean isExit() {
        return false;
    }
}
