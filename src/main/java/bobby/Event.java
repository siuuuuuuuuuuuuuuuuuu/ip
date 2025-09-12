package bobby;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an event task with a start and end time.
 */
public class Event extends Task {
    private final LocalDateTime from;
    private final LocalDateTime to;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma");

    /**
     * Constructs an Event task with the given description and string dates.
     * Throws BobbyException if the date format is invalid.
     *
     * @param description Description of the event task.
     * @param from Start date as a string in d/M/yyyy HHmm format.
     * @param to End date as a string in d/M/yyyy HHmm format.
     * @throws BobbyException If the date format is invalid.
     */
    public Event(String description, String from, String to) throws BobbyException {
        super(description);
        try {
            this.from = LocalDateTime.parse(from, INPUT_FORMAT);
            this.to = LocalDateTime.parse(to, INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new BobbyException("Whatdatmean invalid date format fam. Use d/M/yyyy HHmm like 2/12/2019 1800...");
        }
    }

    /**
     * Constructs an Event task with the given description and LocalDateTime dates.
     *
     * @param description Description of the event task.
     * @param from Start date as a LocalDateTime.
     * @param to End date as a LocalDateTime.
     */
    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the start date of the event.
     *
     * @return The start date as a LocalDateTime.
     */
    public LocalDateTime getFrom() {
        return from;
    }

    /**
     * Returns the end date of the event.
     *
     * @return The end date as a LocalDateTime.
     */
    public LocalDateTime getTo() {
        return to;
    }

    /**
     * Returns a string representation of the event task for display.
     *
     * @return String representation of the event task.
     */
    @Override
    public String toString() {
        return "[E]" + (isDone ? "[X] " : "[ ] ") + description + " (from: " + from.format(OUTPUT_FORMAT) + " to: " + to.format(OUTPUT_FORMAT) + ")";
    }

    /**
     * Returns a string representation of the event task for saving to file.
     *
     * @return Save format string for the event task.
     */
    @Override
    public String toSaveFormat() {
        return String.format("E | %d | %s | %s | %s", isDone ? 1 : 0, description, from.format(INPUT_FORMAT), to.format(INPUT_FORMAT));
    }
}
