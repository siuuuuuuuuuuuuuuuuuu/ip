// src/main/java/bobby/BobbyException.java
package bobby;

/**
 * Custom exception class for Bobby application errors.
 */
public class BobbyException extends Exception {
    /**
     * Constructs a BobbyException with the specified error message.
     *
     * @param message The error message.
     */
    public BobbyException(String message) {
        super(message);
    }
}