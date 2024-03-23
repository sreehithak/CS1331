import java.util.ArrayList;
/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class MovieTheater {
    private ArrayList<String> movies;
    private ArrayList<String> watched;
    /**
     * MovieTheater object constructor.
     * @param movies ArrayList of movies playing at the theater
     * @param watched ArrayList of movies already wtched
     */
    public MovieTheater(ArrayList<String> movies, ArrayList<String> watched) {
        if (movies == null) {
            this.movies = new ArrayList<>();
        } else {
            this.movies = new ArrayList<>(movies);
        }
        if (watched == null) {
            this.watched = new ArrayList<>();
        } else {
            this.watched = new ArrayList<>(watched);
        }
    }
    /**
     * Method that checks to see if a movie is playing at a theater.
     * @param interestingMovies ArrayList of movies to check at the theater
     * @throws FilmNotFoundException if a movie in the interestingMovies ArrayList is not playing at the theater
     */
    public void throwIfMoviesMissing(ArrayList<String> interestingMovies) throws FilmNotFoundException {
        if (interestingMovies == null) {
            throw new IllegalArgumentException("interestingMovies cannot be null!");
        }
        for (int i = 0; i < interestingMovies.size(); i++) {
            if (!(movies.contains(interestingMovies.get(i)))) {
                throw new FilmNotFoundException(interestingMovies.get(i));
            }
        }
    }
    /**
     * Adds String movie to the watched ArrayList.
     * @param movie a String representing a amovie
     * @throws FilmNotFoundException if the movie is not playing at the theater
     * @throws AlreadyWatchedException if the movies has already been watched
     */
    public void watchMovie(String movie) throws FilmNotFoundException, AlreadyWatchedException {
        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null!");
        } else if (!movies.contains(movie)) {
            throw new FilmNotFoundException(movie);
        } else if (watched.contains(movie)) {
            throw new AlreadyWatchedException();
        }
        movies.remove(movie);
        watched.add(movie);
    }
    /**
     * Method that creates an ArrayList of movies that are being planned to watch.
     * @param recommendedMovies ArrayList of movies that a friend recommends
     * @return an ArrayList of movies the user plans to watch
     */
    public ArrayList<String> selectRecommended(ArrayList<String> recommendedMovies) {
        if (recommendedMovies == null) {
            throw new IllegalArgumentException("Movie cannot be null!");
        }
        ArrayList<String> willSee = new ArrayList<>();
        for (int i = 0; i < recommendedMovies.size(); i++) {
            if (movies.contains(recommendedMovies.get(i)) && !watched.contains(recommendedMovies.get(i))) {
                willSee.add(recommendedMovies.get(i));
            }
        }
        return willSee;
    }
    /**
     * Main method.
     * @param args main method parameter
     */
    public static void main(String[] args) {
        ArrayList<String> movies = new ArrayList<>();
        movies.add("Fearless");
        movies.add("Speak Now");
        movies.add("1989");
        movies.add("Red");
        movies.add("Reputation");
        ArrayList<String> watched = new ArrayList<>();
        watched.add("Folklore");
        watched.add("Midnights");
        watched.add("Speak Now");
        watched.add("Evermore");

        MovieTheater amc = new MovieTheater(movies, watched);
        ArrayList<String> recommendedMovies = new ArrayList<String>();
        recommendedMovies.add("Enchanted");
        recommendedMovies.add("Long Live");
        recommendedMovies.add("Never Grow Up");
        recommendedMovies.add("Evermore");

        try {
            amc.throwIfMoviesMissing(movies);
            amc.watchMovie("1989");
            amc.watchMovie("Midnights");
            amc.watchMovie("Debut");
            amc.selectRecommended(recommendedMovies);
            for (String i : recommendedMovies) {
                System.out.println(i);
            }
        } catch (FilmNotFoundException f) {
            System.out.println(f.getMessage());
        } catch (AlreadyWatchedException a) {
            System.out.println(a.getMessage());
        } finally {
            System.out.println("Took a look at the movies!");
        }
    }
}