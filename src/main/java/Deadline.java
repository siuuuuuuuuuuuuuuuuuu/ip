public class Deadline extends Task {
    private String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String getTypeIcon() {
        return "[D]";
    }

    @Override
    public String toString() {
        return getTypeIcon() + getStatus() + " " + getDescription() + " (by: " + by + ")";
    }

    @Override
    public String toStorageString() {
        return "DEADLINE | " + (isMarked ? "1" : "0") + description + " | " + by;
    }
}
