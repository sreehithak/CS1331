/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class InvalidTicketException extends Exception {
    /**
     * Constructor for InvalidTicketException.
     * @param message useful string representation of the exception
     */
    public InvalidTicketException(String message) {
        super(message);
    }
    /**
     * No arg constructor for InvalidTicketException.
     */
    public InvalidTicketException() {
        this("Invalid ticket");
    }
}