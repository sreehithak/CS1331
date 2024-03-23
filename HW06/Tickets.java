import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Tickets {
    /**
     * Method that creates an ArrayList of all the SportsGame objects in the csv file.
     * @param pathName the path name of the csv file
     * @return an ArrayList with all of the SportsGame objects in the csv file
     * @throws FileNotFoundException when the path name is invalid
     * @throws InvalidTicketException when the game is neither Basketball nor Football
     * @throws IllegalArgumentException when the arguments of a method or constructor are invalid
     */
    public static ArrayList<SportsGame> retrieveGames(String pathName)
        throws FileNotFoundException, InvalidTicketException, IllegalArgumentException {
        if (pathName == null || pathName.isBlank()) {
            throw new FileNotFoundException("Path Name is null or blank!");
        }
        File file = new File(pathName);
        if (!(file.exists())) {
            throw new FileNotFoundException("Path Name does not exist!");
        }
        Scanner scan = new Scanner(file);
        //scan.useDelimiter(",");
        ArrayList<SportsGame> input = new ArrayList<>();
        while (scan.hasNextLine()) {
            input.add(processInfo(scan.nextLine()));
        }
        scan.close();
        return input;
    }
    /**
     * Private helper method that turns a String line from a csv file into a SportsGame object.
     * @param info String that represents one SportGame object
     * @return SportGame object that the info String represents
     * @throws InvalidTicketException when the game is neither Basketball nor Football
     * @throws IllegalArgumentException when the arguments of a method or constructor are invalid
     */
    private static SportsGame processInfo(String info)
        throws InvalidTicketException, IllegalArgumentException {
        if(info.length() == 0) {
            throw new IllegalArgumentException();
        }
        String[] sportStr = info.split(",");
        String gameType = sportStr[0];
        if (!gameType.equals("BasketballGame") && !gameType.equals("FootballGame")) {
            throw new InvalidTicketException("This game is neither a BasketballGame or a FootballGame!");
        }
        String ven = sportStr[1];
        String time = sportStr[2];
        String date = sportStr[3];
        int s1 = Integer.parseInt(sportStr[4]);
        int s2 = Integer.parseInt(sportStr[5]);
        int seats = Integer.parseInt(sportStr[6]);
        String ls = sportStr[7];
        if (gameType.equals("BasketballGame")) {
            return new BasketballGame(ven, time, date, s1, s2, seats, ls);
        } else {
            return new FootballGame(ven, time, date, s1, s2, seats, ls);
        }
    }
    /**
     * Method that adds SportsGame objects to a csv file.
     * @param pathName the path name of the csv file
     * @param newGames an ArrayList of SportsGame objects being added to the csv file
     * @throws FileNotFoundException when the path name is invalid
     * @throws InvalidTicketException when the game is neither Basketball nor Football
     * @throws IllegalArgumentException when the arguments of a method or constructor are invalid
     * @throws IOException when there is no file found
     */
    public static void purchaseTickets(String pathName, ArrayList<SportsGame> newGames)
        throws FileNotFoundException, InvalidTicketException, IllegalArgumentException, IOException {
        if (pathName == null || pathName.isBlank()) {
            throw new IllegalArgumentException("Path Name cannot be null or blank!");
        }
        File file = new File(pathName);
        if (!file.exists()) {
            file.createNewFile();
        }
        ArrayList<SportsGame> allGames = retrieveGames(pathName);
        for (int i = 0; i < newGames.size(); i++) {
            allGames.add(newGames.get(i));
        }
        for (int i = 0; i < allGames.size(); i++) {
            if (allGames.get(i).getSeatsLeft() <= 0) {
                allGames.remove(i);
            }
        }
        PrintWriter write = new PrintWriter(file);
        for (int i = 0; i < allGames.size(); i++) {
            write.println(allGames.get(i));
        }
        write.close();
    }
    /**
     * Method that locates all of the instances of a SportsGame object.
     * @param pathName the path name of the csv file
     * @param game SportsGame object that is being searched for
     * @return an ArrayList of Integers that represents the index of the parameter fame
     * @throws FileNotFoundException when the path name is invalid
     * @throws InvalidTicketException when the game is neither Basketball nor Football
     * @throws IllegalArgumentException when the arguments of a method or constructor are invalid
     */
    public static ArrayList<Integer> findTickets(String pathName, SportsGame game)
        throws FileNotFoundException, InvalidTicketException, IllegalArgumentException {
        if (pathName == null || pathName.isBlank()) {
            throw new IllegalArgumentException("Path Name cannot be null or blank!");
        }
        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<SportsGame> gameList = retrieveGames(pathName);
        for (int i = 0; i < gameList.size(); i++) {
            if (gameList.get(i).equals(game)) {
                aList.add(i);
            }
        }
        if (aList.size() == 0) {
            throw new InvalidTicketException("SportsGame not found in file!");
        }
        return aList;
    }
    /**
     * Method that removes a SportsGame object from a csv object.
     * @param pathName the path name of the csv file
     * @param game SportsGame object that is being attended
     * @throws FileNotFoundException when the path name is invalid
     * @throws InvalidTicketException when the game is neither Basketball nor Football
     * @throws IllegalArgumentException when the arguments of a method or constructor are invalid
     */
    public static void attendGame(String pathName, SportsGame game)
        throws FileNotFoundException, InvalidTicketException, IllegalArgumentException {
        if (pathName == null || pathName.isBlank()) {
            throw new IllegalArgumentException("Path Name cannot be null or blank!");
        }
        ArrayList<SportsGame> gameList = retrieveGames(pathName);
        ArrayList<Integer> aList = findTickets(pathName, game);
        if (aList.size() == 0) {
            throw new InvalidTicketException("SportsGame object not found!");
        }
        for (int i = 0; i < aList.size(); i++) {
            gameList.remove(i);
        }
        File file = new File(pathName);
        file.delete();
        file.createNewFile();
        PrintWriter write = new PrintWriter(file);
        for (int i = 0; i < gameList.size(); i++) {
            write.println(gameList.get(i));
        }
        write.close();
    }
}