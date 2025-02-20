/** Melanie Schwartz
 * sno122
 */
package utsa.Project1;

// TVShows class extending Media attributes
public class TVShows extends Media {
    // TODO: Class needs to contain the following datatypes per instructions - id, type, title, director, country, release_year, rating, number_of_seasons, description
    private String director;
    private String country;
    private String rating;
    private int numberOfSeasons;
    private String description;

    // TVShow constructor
    public TVShows(int id, String title, String director, String country, int releaseYear, String rating, int numberOfSeasons, String description) {
        super(id, title, releaseYear);
        this.director = director;
        this.country = country;
        this.rating = rating;
        this.numberOfSeasons = numberOfSeasons;
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

    // Return rating
    public String getRating() {
        return rating;
    }

    // Return number of seasons
    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    // return description
    public String getDescription() {
        return description;
    }

    // // Return relevant details about TVShows
    @Override
    public String getDetails() {
        return title;
    }
}
