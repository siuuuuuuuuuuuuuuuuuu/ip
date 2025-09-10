public class Parser {
    public static Command parse(String fullCommand) throws BobbyException {
        String[] words = fullCommand.split(" ", 2);
        String commandWord = words[0];
        String arguments = words.length > 1 ? words[1] : "";

        switch (commandWord) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "done":
                return new DoneCommand(arguments);
            case "delete":
                return new DeleteCommand(arguments);
            case "todo":
                return new AddCommand("todo", arguments);
            case "deadline":
                return new AddCommand("deadline", arguments);
            case "event":
                return new AddCommand("event", arguments);
            case "find":
                return new FindCommand(arguments);
            default:
                throw new BobbyException("Whatdatmean i dont know that one");
        }
    }
}
