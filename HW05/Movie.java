/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Movie extends Media {
    /** The runtime of a movie in minutes. */
    private int runtime;
    /**
     * Movie object constructor.
     * @param genre The genre
     * @param name The name
     * @param rating The customer rating
     * @param rentalPrice The price in dollars to rent
     * @param runtime The runtime of a movie in minutes.
     */
    public Movie(Genre genre, String name, int rating, double rentalPrice, int runtime) {
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }
    /**
     * Movie object constructor.
     * @param genre The genre
     * @param name The name
     * @param rating The customer rating
     */
    public Movie(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 111);
    }
    @Override
    public String toString() {
        return super.toString() + String.format(", Runtime: %d", runtime);
    }
    @Override
    public boolean equals(Object other) {
        if (super.equals(other)) {
            if (other instanceof Movie) {
                Movie otherMovie = (Movie) other;
                return this.runtime == otherMovie.runtime;
            }
        }
        return false;
    }
}