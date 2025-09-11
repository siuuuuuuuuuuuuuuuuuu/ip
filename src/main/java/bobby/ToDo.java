package bobby;

public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + (isDone ? "[X] " : "[ ] ") + description;
    }

    @Override
    public String toSaveFormat() {
        return String.format("T | %d | %s", isDone ? 1 : 0, description);
    }
}
