/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class BasketballGame extends SportsGame {
    private String league;
    /**
     * BasketballGame object constructor.
     * @param venue String representation of the venue of the game
     * @param startTime String representation of the start time of the game
     * @param startDate String representation of date of the game
     * @param score1 int that represents the first team's score
     * @param score2 int that represents the second team's score
     * @param seatsLeft int that represents the number of seats remaining in the venue
     * @param league String that represents the name of the league
     */
    public BasketballGame(String venue, String startTime, String startDate,
        int score1, int score2, int seatsLeft, String league) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (league == null || league.isBlank()) {
            throw new IllegalArgumentException("The league is blank or null!");
        }
        this.league = league;
    }
    @Override
    public String toString() {
        return String.format("BasketballGame,%s,%s", super.toString(), league);
    }
    @Override
    public boolean equals(Object other) {
        if (super.equals(other) && other instanceof BasketballGame) {
            BasketballGame basket = (BasketballGame) other;
            return this.league.equals(basket.league);
        }
        return false;
    }
}