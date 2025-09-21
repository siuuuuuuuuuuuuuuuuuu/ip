package bobby;

import bobby.bobbyexception.BobbyException;
import bobby.command.AddDeadlineCommand;
import bobby.command.AddEventCommand;
import bobby.command.AddTodoCommand;
import bobby.command.Command;
import bobby.command.DeleteCommand;
import bobby.command.MarkCommand;
import bobby.command.ExitCommand;
import bobby.command.FindCommand;
import bobby.command.ListCommand;
import bobby.command.UnmarkCommand;

/**
 * Parses user input commands and returns the corresponding Command object.
 */
public class Parser {
    /**
     * Parses the full user command string and returns the appropriate Command object.
     *
     * @param fullCommand The full command string entered by the user.
     * @return The corresponding Command object.
     * @throws BobbyException If the command is invalid or arguments are missing.
     */
    public static Command parse(String fullCommand) throws BobbyException {
        assert fullCommand != null : "Input command should not be null";
        String[] words = fullCommand.trim().split(" ", 2);
        String command = words[0];
        switch (command) {
        case "list":
            return new ListCommand();
        case "mark":
            int doneIndex = Integer.parseInt(words[1]) - 1;
            return new MarkCommand(doneIndex);
        case "unmark":
            int undoneIndex = Integer.parseInt(words[1]) - 1;
            return new UnmarkCommand(undoneIndex);
        case "delete":
            int deleteIndex = Integer.parseInt(words[1]) - 1;
            return new DeleteCommand(deleteIndex);
        case "todo":
            if (words.length < 2 || words[1].trim().isEmpty()) {
                throw new BobbyException("Whatdatmean the description of a todo cannot be empty.");
            }
            return new AddTodoCommand(words[1].trim());
        case "deadline":
            String[] deadlineParts = words[1].split("/by", 2);
            if (deadlineParts.length < 2) {
                throw new BobbyException("Deadline must have a /by date famalam");
            }
            return new AddDeadlineCommand(deadlineParts[0].trim(), deadlineParts[1].trim());
        case "event":
            String[] eventParts = words[1].split("/from|/to");
            if (eventParts.length < 3) {
                throw new BobbyException("Event must have /from and /to dates bro try again!");
            }
            return new AddEventCommand(eventParts[0].trim(), eventParts[1].trim(), eventParts[2].trim());
        case "find":
            if (words.length < 2 || words[1].trim().isEmpty()) {
                throw new BobbyException("Whatdatmean the search keyword cant be empty fam");
            }
            return new FindCommand(words[1].trim());
        case "bye":
            return new ExitCommand();
        case "viewschedule":
            if (words.length < 2 || words[1].trim().isEmpty()) {
                throw new BobbyException("Please specify a date in d/M/yyyy format, e.g., viewschedule 19/09/2025");
            }
            return new bobby.command.ViewScheduleCommand(words[1].trim());
        default:
            throw new BobbyException("Whatdatmean");
        }
    }
}
