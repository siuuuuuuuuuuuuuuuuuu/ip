public class Task {
    private final String description;
    private boolean isMarked;

    public Task(String description) {
        this.description = description;
        this.isMarked = false;
    }

    public void mark() {
        this.isMarked = true;
    }

    public void unmark() {
        this.isMarked = false;
    }

    public boolean isMarked() {
        return this.isMarked;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatus() {
        return (isMarked ? "[X]" : "[ ]");
    }
}
