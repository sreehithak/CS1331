/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public abstract class SportsGame {
    private String venue;
    private String startTime;
    private String startDate;
    private int score1;
    private int score2;
    private int seatsLeft;
    /**
     * SportsGame object constructor.
     * @param venue String representation of the venue of the game
     * @param startTime String representation of the start time of the game
     * @param startDate String representation of date of the game
     * @param score1 int that represents the first team's score
     * @param score2 int that represents the second team's score
     * @param seatsLeft int that represents the number of seats remaining in the venue
     */
    public SportsGame(String venue, String startTime, String startDate, int score1, int score2, int seatsLeft) {
        if (venue == null || venue.isBlank() || startTime == null || startTime.isBlank() || startDate == null
            || startDate.isBlank()) {
            throw new IllegalArgumentException("Atleast one of your String arguments is blank or null!");
        } else if (score1 < 0 || score2 < 0 || seatsLeft < 0) {
            throw new IllegalArgumentException("Atleast one of your integer arguments is negative!");
        } else {
            this.venue = venue;
            this.startTime = startTime;
            this.startDate = startDate;
            this.score1 = score1;
            this.score2 = score2;
            this.seatsLeft = seatsLeft;
        }
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", venue, startTime, startDate, score1, score2, seatsLeft);
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof SportsGame) {
            SportsGame otherSport = (SportsGame) other;
            return this.venue.equals(otherSport.venue) && this.startTime.equals(otherSport.startTime)
                && this.startDate.equals(otherSport.startDate) && this.score1 == otherSport.score1
                && this.score2 == otherSport.score2 && this.seatsLeft == otherSport.seatsLeft;
        }
        return false;
    }
    /**
     * Accessor method for seatsLeft.
     * @return the number of seats left in the venue
     */
    public int getSeatsLeft() {
        return seatsLeft;
    }
}