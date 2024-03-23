/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class AlreadyWatchedException extends RuntimeException {
    /**
     * AlreadyWatchedException object contructor.
     */
    public AlreadyWatchedException() {
        super("You've already seen this movie here!");
    }
}