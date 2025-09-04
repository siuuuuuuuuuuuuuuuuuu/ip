public abstract class Task {
    protected String description;
    public abstract String toStorageString();
    public static Task fromStorageString(String line) {
        String[] parts = line.split("\\|");
        String type = parts[0];
        switch (type) {
            case "T":
                ToDo todo = new ToDo(parts[2]);
                if (parts[1].equals("1")) {
                    todo.mark();
                }
                return todo;
            case "D":
                Deadline deadline = new Deadline(parts[2], parts[3]);
                if (parts[1].equals("1")) {
                    deadline.mark();
                }
                return deadline;
            case "E":
                Event event = new Event(parts[2], parts[3], parts[4]);
                if (parts[1].equals("1")) {
                    event.mark();
                }
                return event;
            default:
                throw new IllegalArgumentException("Unknown task type: " + type);
        }
    }
    protected boolean isMarked;

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

    public abstract String getTypeIcon();
    public abstract String toString();
}
