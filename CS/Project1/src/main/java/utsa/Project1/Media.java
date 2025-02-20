/** Melanie Schwartz
 * sno122
 */
package utsa.Project1;

// Abstract base class representing a generic media
public abstract class Media {
    protected int id;
    protected String title;
    protected int releaseYear;

    // Media constructor
    public Media(int id, String title, int releaseYear) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
    }
    // Return ID
    public int getId() {
        return id;
    }

    // Return title
    public String getTitle() {
        return title;
    }

    // Return release year
    public int getReleaseYear() {
        return releaseYear;
    }

    // Return details; overidden in each class for specified details
    public abstract String getDetails();
}










