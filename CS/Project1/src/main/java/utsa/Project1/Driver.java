/** Melanie Schwartz
 * sno122
 */
package utsa.Project1;

import java.io.IOException;

// TODO: Driver class will be responsible for instantiating a single manager Class and giving it the filename for it to load in all of the product data.
//  Have Driver then call each of the analyses listed above in the order they are listed and print out each result that is returned on a separate line.
//  Make sure to print out a message/label with the result and not just the value (e.g., for the first calculation, there should be 41 total products,
//  do not just print out “41”, instead print out something like “Total number of products: 41”).
public class Driver {
    public static void main(String[] args) {
        MediaManager manager = new MediaManager();

        try {
            // Load media data from the CSV file
            String filePath = "/Users/melanieschwartz/IdeaProjects/Project1/src/main/java/utsa/Project1/project1dataset.csv";
            manager.loadCSV(filePath);

            // Produce and print results
            System.out.println("Total number of products: " + manager.countTotalProducts());
            System.out.println("Total number of Movies: " + manager.countByType(Movies.class));
            System.out.println("Total number of TV Shows: " + manager.countByType(TVShows.class));
            System.out.println("Total number of Video Games: " + manager.countByType(VideoGames.class));
            System.out.println("Total number of Music Albums: " + manager.countByType(MusicAlbums.class));

            Media oldestProduct = manager.findOldestProduct();
            if (oldestProduct != null) {
                System.out.println("Oldest product: " + oldestProduct.getDetails());
            } else {
                System.out.println("Oldest product: No products available.");
            }

            MusicAlbums mostPopularAlbum = manager.findMostPopularAlbum();
            if (mostPopularAlbum != null) {
                System.out.println("Most popular Music Album: " + mostPopularAlbum.getDetails());
            } else {
                System.out.println("Most popular Music Album: No music albums available.");
            }

            VideoGames mostPopularGame = manager.findMostPopularGame();
            if (mostPopularGame != null) {
                System.out.println("Most popular Video Game: " + mostPopularGame.getDetails());
            } else {
                System.out.println("Most popular Video Game: No video games available.");
            }

            String mostCommonRating = manager.findCommonAgeRating();
            if (mostCommonRating != null) {
                System.out.println("Most common age rating among Movies/TV shows: " + mostCommonRating);
            } else {
                System.out.println("Most common age rating: No ratings available.");
            }

            Movies shortestMovies = manager.findShortestMovie();
            if (shortestMovies != null) {
                System.out.println("Shortest Movie: " + shortestMovies.getDetails());
            } else {
                System.out.println("Shortest Movie: No movies available.");
            }

            MusicAlbums shortestAlbum = manager.findShortestMusicAlbum();
            if (shortestAlbum != null) {
                System.out.println("Shortest Music Album: " + shortestAlbum.getDetails());
            } else {
                System.out.println("Shortest Music Album: No music albums available.");
            }
        // Error handling
        } catch (IOException e) {
            System.err.println("Error reading the data file: " + e.getMessage());
        }
    }
}
