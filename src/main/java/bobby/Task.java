package bobby;

/**
 * Abstract base class representing a task in the Bobby application.
 * Stores description and completion status, and provides common operations.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new Task with the given description.
     *
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks this task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Returns whether this task is marked as done.
     *
     * @return true if the task is done, false otherwise.
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Returns the description of this task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a string representation of the task for display.
     *
     * @return String representation of the task.
     */
    public abstract String toString();

    /**
     * Returns a string representation of the task for saving to file.
     *
     * @return Save format string for the task.
     */
    public abstract String toSaveFormat();
}
