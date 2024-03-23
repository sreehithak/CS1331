/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public abstract class Media implements Comparable<Media> {
    /**The genre of the media item. */
    private Genre genre;
    /**The name.*/
    private String name;
    /**The customer rating*/
    private int rating;
    /**The price in dollars to rent*/
    private double rentalPrice;
    /**
     * Media object constructor.
     * @param genre The genre
     * @param name The name
     * @param rating The customer rating
     * @param rentalPrice The price in dollars to rent
     */
    public Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }
    /**
     * Media object constructor.
     * @param genre The genre
     * @param name The name
     * @param rating The customer rating
     */
    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }
    @Override
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f", genre, name, rating, rentalPrice);
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof Media) {
            Media otherMedia = (Media) other;
            return this.genre == otherMedia.genre && this.name.equals(otherMedia.name)
                && this.rating == otherMedia.rating && this.rentalPrice == otherMedia.rentalPrice;
        }
        return false;
    }
    @Override
    public int compareTo(Media other) {
        if (this.genre.ordinal() > other.genre.ordinal()) {
            return 1;
        } else if (this.genre.ordinal() < other.genre.ordinal()) {
            return -1;
        } else {
            switch (this.name.compareTo(other.name)) {
            case -1:
                return -1;
            case 1:
                return 1;
            case 0:
                if (this.rating > other.rating) {
                    return 1;
                } else if (this.rating < other.rating) {
                    return -1;
                } else {
                    return 0;
                }
            default:
                break;
            }
            return -1000;
        }
    }
    /**
     * accessor method for name.
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * accessor method for genre.
     * @return the genre
     */
    public Genre getGenre() {
        return genre;
    }
    /**
     * accessor method for rating.
     * @return the rating
     */
    public int getRating() {
        return rating;
    }
    /**
     * accessor method for rentalPrice.
     * @return the rentalPrice
     */
    public double getRentalPrice() {
        return rentalPrice;
    }
}