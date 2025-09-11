package bobby;

public class ExitCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showLine();
        System.out.println("Safety fam");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
