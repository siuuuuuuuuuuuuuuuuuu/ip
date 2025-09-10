public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showError("bye bye see you next time")
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
