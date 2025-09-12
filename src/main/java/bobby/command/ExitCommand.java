package bobby.command;

import bobby.*;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showLine();
        System.out.println("Goodbye! Have a great day.");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
