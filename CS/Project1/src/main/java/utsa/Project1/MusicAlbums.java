/** Melanie Schwartz
 * sno122
 */

package utsa.Project1;

// MusicAlbums class extending abstract Media attributes
public class MusicAlbums extends Media {
    // TODO: Class needs to contain the following datatypes per instructions - id, type, release_year, artist,title, global_sales, tracks, duration_(minutes), genre
    private String artist;
    private double globalSales;
    private int tracks;
    private double duration;
    private String genre;

    // MusicAlbums Constructor
    public MusicAlbums(int id, int releaseYear, String artist, String title, double globalSales, int tracks, double duration, String genre) {
        super(id, title, releaseYear);
        this.artist = artist;
        this.globalSales = globalSales;
        this.tracks = tracks;
        this.duration = duration;
        this.genre = genre;
    }

    // Return artist
    public String getArtist() {
        return artist;
    }

    // Return sales
    public double getGlobalSales() {
        return globalSales;
    }

    // Return number of tracks
    public int getTracks() {
        return tracks;
    }

    // Return album duration
    public double getDuration() {
        return duration;
    }

    // Return genre
    public String getGenre() {
        return genre;
    }

    // Return relevant details about MusicAlbums
    @Override
    public String getDetails() {
        return title + ", " + artist + " (" + duration + "min)";
    }
}
