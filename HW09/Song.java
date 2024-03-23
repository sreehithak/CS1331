/**
 * @author Sreehitha Kalagara
 * @version 1.0
 */
public class Song {
    private String songName;
    private String albumName;
    private Genres value;
    /**
     * Song object contructor.
     * @param songName String representation of the song name
     * @param albumName String representation of the album name
     * @param value enum representing the Genre of the song
     */
    public Song(String songName, String albumName, Genres value) {
        if (songName.isEmpty()) {
            this.songName = "Untitled";
        } else {
            this.songName = songName;
        }
        if (albumName.isEmpty()) {
            this.albumName = "Taylor Swift";
        } else {
            this.albumName = albumName;
        }
        if (value == null) {
            this.value = Genres.POP;
        } else {
            this.value = value;
        }
    }
    /**
     * Accessor method for albumName.
     * @return albumName
     */
    public String getAlbumName() {
        return albumName;
    }
    @Override
    public String toString() {
        return songName + "\n" + albumName + "\n" + value.toString();
    }
}