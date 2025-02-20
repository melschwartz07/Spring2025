/** Melanie Schwartz
 * sno122
 */
package utsa.Project1;

// Movies class extending abstract Media attributes
public class Movies extends Media {
    // TODO: Class needs to contain the following datatypes per instructions - id, type, title, director, country, release_year, rating,duration_(minutes), description
    private String director;
    private String country;
    private String rating;
    private int duration;
    private String description;

    // Movies class constructor
    public Movies(int id, String title, String director, String country, int releaseYear, String rating, int duration, String description) {
        super(id, title, releaseYear);
        this.director = director;
        this.country = country;
        this.rating = rating;
        this.duration = duration;
        this.description = description;
    }

    // Return director
    public String getDirector() {
        return director;
    }

    // Return country
    public String getCountry() {
        return country;
    }

    // Return movie duration
    public int getDuration() {
        return duration;
    }

    // Return Movie rating
    public String getRating() {
        return rating;
    }

    // return movie description
    public String getDescription() {
        return description;
    }

    // Return relevant details about Movies
    @Override
    public String getDetails() {
        return title + ", " + director + " (" + duration + "min)";
    }
}
