/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class FootballGame extends SportsGame {
    private String singer;
    /**
     * FootballGame object constructor.
     * @param venue String representation of the venue of the game
     * @param startTime String representation of the start time of the game
     * @param startDate String representation of date of the game
     * @param score1 int that represents the first team's score
     * @param score2 int that represents the second team's score
     * @param seatsLeft int that represents the number of seats remaining in the venue
     * @param singer name of the singer performing at the half-time show
     */
    public FootballGame(String venue, String startTime, String startDate,
        int score1, int score2, int seatsLeft, String singer) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (singer == null || singer.isBlank()) {
            throw new IllegalArgumentException("The singer is blank or null!");
        }
        this.singer = singer;
    }
    @Override
    public String toString() {
        return String.format("FootballGame,%s,%s", super.toString(), singer);
    }
    @Override
    public boolean equals(Object other) {
        if (super.equals(other) && other instanceof FootballGame) {
            FootballGame foot = (FootballGame) other;
            return this.singer.equals(foot.singer);
        }
        return false;
    }
}
