public class Event extends Task {
    private String from;
    private String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getTypeIcon() {
        return "[E]";
    }

    @Override
    public String toString() {
        return getTypeIcon() + getStatus() + " " + getDescription() + " (from: " + from + " to: " + to + ")";
    }

    @Override
    public String toStorageString() {
        return "EVENT | " + (isMarked ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}
