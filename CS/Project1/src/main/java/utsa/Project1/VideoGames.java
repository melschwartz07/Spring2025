/** Melanie Schwartz
 * sno122
 */
package utsa.Project1;

// VideoGames class extending abstract Media attributes
public class VideoGames extends Media {
    // TODO: Class needs to contain the following datatypes per instructions - id, type, title, platform, release_year, genre, publisher, copies_sold_(millions)
    private String platform;
    private String genre;
    private String publisher;
    private double copiesSold;

    // VideoGame Constructor
    public VideoGames(int id, String title, String platform, int releaseYear, String genre, String publisher, double copiesSold) {
        super(id, title, releaseYear);
        this.platform = platform;
        this.genre = genre;
        this.publisher = publisher;
        this.copiesSold = copiesSold;
    }

    // Return platform type
    public String getPlatform() {
        return platform;
    }

    // Return genre
    public String getGenre() {
        return genre;
    }

    // Return Publisher
    public String getPublisher() {
        return publisher;
    }

    // Return copies sold
    public double getCopiesSold() {
        return copiesSold;
    }

    // Return relevant details about VideoGames
    @Override
    public String getDetails() {
        return title + ", " + copiesSold + "m copies sold.";
    }
}
