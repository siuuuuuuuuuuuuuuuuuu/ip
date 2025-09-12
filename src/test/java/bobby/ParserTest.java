package bobby;

import bobby.Parser;
import bobby.command.ListCommand;
import bobby.BobbyException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    @Test
    public void testParseValidCommand() throws BobbyException {
        Parser parser = new Parser();
        assertInstanceOf(ListCommand.class, parser.parse("list"));
    }

    @Test
    public void testParseInvalidCommand() {
        Parser parser = new Parser();
        assertThrows(BobbyException.class, () -> parser.parse("unknown"));
    }
}
