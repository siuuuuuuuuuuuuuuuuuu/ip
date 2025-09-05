import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private LocalDateTime by;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");

    public Deadline(String description, String by) throws BobbyException {
        super(description);
        try {
            this.by = LocalDateTime.parse(by, INPUT_FORMAT);
        } catch (DateTimeParseException e) {
            throw new BobbyException("Whatdatmean the date and time format is wrong. Use d/M/yyyy HHmm like 2/12/2019 1800");
        }
    }

    @Override
    public String getTypeIcon() {
        return "[D]";
    }

    @Override
    public String toString() {
        String statusIcon = isMarked ? "[X]" : "[ ]";
        return "[D]" + statusIcon + " " + description + " (by: " + by.format(OUTPUT_FORMAT) + ")";
    }

    @Override
    public String toStorageString() {
        return "DEADLINE | " + (isMarked ? "1" : "0") + " | " + description + " | " + by.format(INPUT_FORMAT);
    }

    public static Deadline fromStorageString(String data) {
        try {
            String[] parts = data.split(" \\| ");
            if (parts.length != 4) {
                throw new BobbyException("Whatdatmean invalid storage format for Deadline");
            }
            Deadline deadline = new Deadline(parts[2], parts[3]);
            if (parts[1].equals("1")) {
                deadline.mark();
            }
            return deadline;
        } catch (BobbyException e) {
            throw new RuntimeException(e);
        }
    }

    public LocalDateTime getBy() {
        return by;
    }
}
