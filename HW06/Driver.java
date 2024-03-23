import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Driver {
    /**
     * Main method.
     * @param args String array argument of main method
     * @throws FileNotFoundException when the path name is invalid
     * @throws InvalidTicketException when the game is neither Basketball nor Football
     * @throws IllegalArgumentException when the arguments of a method or constructor are invalid
     * @throws IOException when there is no file found
     */
    public static void main(String[] args)
        throws FileNotFoundException, InvalidTicketException, IllegalArgumentException, IOException {
        BasketballGame bgame1 = new BasketballGame("State Farm", "12:00", "4/20", 5, 6, 4, "nba");
        BasketballGame bgame2 = new BasketballGame("Coca Cola Roxy", "2:00", "4/21", 21, 60, 0, "wnba");
        FootballGame fgame1 = new FootballGame("Mercedes Benz", "5:00", "2/8", 45, 8, 100, "Rihanna");
        FootballGame fgame2 = new FootballGame("Fox Theater", "10:00", "2/29", 32, 21, 76, "Katy Perry");
        ArrayList<SportsGame> newGames = new ArrayList<>();
        newGames.add(fgame2);
        newGames.add(bgame1);
        newGames.add(fgame1);
        newGames.add(bgame2);
        Tickets.purchaseTickets("TestTickets.csv", newGames);
        BasketballGame bgame3 = new BasketballGame("The Eastern", "4:00", "5/27", 18, 19, 16, "nba");
        ArrayList<SportsGame> moreGames = new ArrayList<>();
        moreGames.add(bgame3);
        Tickets.purchaseTickets("TestTickets.csv", moreGames);
        ArrayList<SportsGame> sports = Tickets.retrieveGames("TestTickets.csv");
        for (int i = 0; i < sports.size(); i++) {
            System.out.println(sports.get(i));
        }
        Tickets.attendGame("TestTickets.csv", bgame1);
        //Tickets.attendGame("TestTickets.csv", bgame2);
        //Tickets.attendGame("TestTickets.csv", fgame1);
        //Tickets.attendGame("TestTickets.csv", fgame2);
        //Tickets.attendGame("TestTickets.csv", bgame3);
        System.out.println("---------------------------------------------------------");
        ArrayList<SportsGame> newSports = Tickets.retrieveGames("TestTickets.csv");
        for (int i = 0; i < newSports.size(); i++) {
            System.out.println(newSports.get(i));
        }
    }
}
