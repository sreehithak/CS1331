import java.util.ArrayList;
/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Blockbuster {
    /** an ArrayList of type Media. */
    private ArrayList<Media> mediaItems;
    /** a Blockbuster object constructor. */
    public Blockbuster() {
        mediaItems = new ArrayList<Media>();
    }
    /**
     * Adds a valid Media item to the back of the ArrayList.
     * @param mediaItem the media object being added to the list
     */
    public void addMedia(Media mediaItem) {
        mediaItems.add(mediaItem);
    }
    /**
     * Method that removes a Media object from the mediaItems arrayList.
     * @param mediaItem the Media object the method is trying to remove
     * @return the mediaItem removed, nul
     */
    public Media removeMedia(Media mediaItem) {
        for (int i = 0; i < mediaItems.size(); i++) {
            if (mediaItems.get(i).equals(mediaItem)) {
                Media itemRemoved = mediaItems.get(i);
                mediaItems.remove(i);
                return itemRemoved;
            }
        }
        return null;
    }
    /**
     * Method that sorts the mediaItems array list in ascending order.
     */
    public void sortMedia() {
        for (int i = 0; i < mediaItems.size(); i++) {
            int minIndex = i;
            for (int x = (i + 1); x < mediaItems.size(); x++) {
                if (mediaItems.get(x).compareTo(mediaItems.get(minIndex)) == -1) {
                    minIndex = x;
                }
            }
            if (minIndex != i) {
                Media itemSwap = mediaItems.get(i);
                mediaItems.set(i, mediaItems.get(minIndex));
                mediaItems.set(minIndex, itemSwap);
            }
        }
    }
    /**
     * Method that finds a media item.
     * @param mediaItem takes in a media object we are trying to find
     * @return the media object in the mediaItems arrayList that we found
     */
    public Media findMedia(Media mediaItem) {
        sortMedia();
        int low = 0;
        int high = mediaItems.size() - 1;
        int mid;
        int i = 0;
        do {
            mid = (low + high) / 2;
            switch (mediaItems.get(mid).compareTo(mediaItem)) {
            case 0:
                return mediaItems.get(mid);
            case 1:
                high = mid - 1;
                break;
            case -1:
                low = mid + 1;
                break;
            default:
                break;
            }
            i++;
        } while (i < mediaItems.size());
        //&& mediaItems.get(mid).equals(mediaItem)
        // if (mediaItem.equals(mediaItems.get(mid))) {
        //     return mediaItems.get(mid);
        // }
        return null;
    }
    /**
     * Method that tells the user what the most popular movie in the array list is.
     * @return a String containing information about the most popular movie
     */
    public String mostPopularMovie() {
        if (mediaItems.size() == 0) {
            return "No movies were found.";
        }
        int maxIndex = 0;
        for (int i = 0; i < mediaItems.size(); i++) {
            if (mediaItems.get(i) instanceof Movie
                && mediaItems.get(i).getRating() > mediaItems.get(maxIndex).getRating()) {
                maxIndex = i;
            }
        }
        if (mediaItems.get(maxIndex) instanceof VideoGame) {
            return "No movies were found.";
        }
        return String.format("With a rating of %d, our customers enjoy watching %s the most!",
            mediaItems.get(maxIndex).getRating(), mediaItems.get(maxIndex).getName());
    }
}