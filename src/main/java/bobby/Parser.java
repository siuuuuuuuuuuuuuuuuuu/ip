package bobby;

import bobby.command.*;

public class Parser {
    public static Command parse(String fullCommand) throws BobbyException {
        String[] words = fullCommand.trim().split(" ", 2);
        String command = words[0];
        switch (command) {
            case "list":
                return new ListCommand();
            case "done":
                int doneIndex = Integer.parseInt(words[1]) - 1;
                return new DoneCommand(doneIndex);
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
            default:
                throw new BobbyException("Whatdatmean");
        }
    }
}
