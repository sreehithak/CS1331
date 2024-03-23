/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class FilmNotFoundException extends Exception {
    /**
     * FilmNotFoundException object contructor.
     * @param movie String representing a movie
     */
    public FilmNotFoundException(String movie) {
        super(String.format("%s is not playing at this movie theater.", movie));
    }
}