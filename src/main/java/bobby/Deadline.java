package bobby;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a task with a deadline, storing the due date and description.
 */
public class Deadline extends Task {
    private LocalDateTime by;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma");

    /**
     * Constructs a Deadline task with the given description and deadline string.
     *
     * @param description Description of the deadline task.
     * @param by Deadline date as a string in d/M/yyyy HHmm format.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = LocalDateTime.parse(by, INPUT_FORMAT);
    }

    /**
     * Constructs a Deadline task with the given description and deadline date.
     *
     * @param description Description of the deadline task.
     * @param by Deadline date as a LocalDateTime.
     */
    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns the deadline date of this task.
     *
     * @return The deadline as a LocalDateTime.
     */
    public LocalDateTime getBy() {
        return by;
    }

    /**
     * Returns a string representation of the deadline task for display.
     *
     * @return String representation of the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + (isDone ? "[X] " : "[ ] ") + description + " (by: " + by.format(OUTPUT_FORMAT) + ")";
    }

    /**
     * Returns a string representation of the deadline task for saving to file.
     *
     * @return Save format string for the deadline task.
     */
    @Override
    public String toSaveFormat() {
        return String.format("D | %d | %s | %s", isDone ? 1 : 0, description, by.format(INPUT_FORMAT));
    }
}
