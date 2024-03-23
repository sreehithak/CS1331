/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class VideoGame extends Media {
    /** the max number of players that can play the game at once */
    private int maxPlayers;
    /** whether the video game needs a gaming console to play */
    private boolean needsConsole;
    /**
     * Video Game object constructor.
     * @param genre The genre
     * @param name The name
     * @param rating The customer rating
     * @param rentalPrice The price in dollars to rent
     * @param maxPlayers The max number of players
     * @param needsConsole wWether the video game needs a gaming console
     */
    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needsConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needsConsole;
    }
    /**
     * Video Game object constructor.
     * @param genre The genre
     * @param name The name
     * @param rating The customer rating
     */
    public VideoGame(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 2, false);
    }
    /**
     * accessor method for console.
     * @return the rentalPrice
     */
    public boolean getneedsConsole() {
        return needsConsole;
    }
    @Override
    public String toString() {
        String str;
        if (needsConsole) {
            str = "needs";
        } else {
            str = "does not need";
        }
        return String.format("This is a %d-player %s video game called %s that %s a gaming console to play.",
            maxPlayers, getGenre(), getName(), str);
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof VideoGame) {
            VideoGame otherGame = (VideoGame) other;
            return super.equals(other) && this.maxPlayers == otherGame.maxPlayers
                && this.needsConsole == otherGame.needsConsole;
        }
        return false;
    }
}