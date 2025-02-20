/** Melanie Schwartz
 * sno122
 */
package utsa.Project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO: The manager Class will be responsible for loading in the data from the given csv file.
//  Please make this a method that will accept a String as a parameter which will be the file name that contains the product data you are reading into your program
// Manage the inventory of each classification of media products
public class MediaManager {
    // TODO: The manager Class must store/access ALL media through a SINGLE ArrayList
    private ArrayList<Media> mediaList;

    public MediaManager() {
        mediaList = new ArrayList<>();
    }

    // Handles loading data from a CSV file and performing the analysis
    public void loadCSV(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                try {
                    // Split using a comma delimiter
                    String[] data = line.split(",", -1);

                    // trim() implemented for data cleaning - removes any leading and trailing whitespace from a string
                    // Cleans up raw id fields and converts to int for number handling
                    // Standardizes the cleaned media type into a consistent format for categorizing
                    int id = Integer.parseInt(data[0].trim());
                    String typeField = data[1].trim();
                    String type = consistentData(typeField);

                    switch (type) {
                        case "Movie":
                            mediaList.add(new Movies(
                                    id, data[2].trim(), data[3].trim(),
                                    data[4].trim(), Integer.parseInt(data[5].trim()),
                                    data[6].trim(), Integer.parseInt(data[7].trim()),
                                    data[8].trim()
                            ));
                            break;
                        case "TVShow":
                            mediaList.add(new TVShows(
                                    id, data[2].trim(), data[3].trim(),
                                    data[4].trim(), Integer.parseInt(data[5].trim()),
                                    data[6].trim(), searchSeasons(data[7].trim()),
                                    data[8].trim()
                            ));
                            break;
                        case "VideoGame":
                            mediaList.add(new VideoGames(
                                    id, data[2].trim(), data[3].trim(),
                                    Integer.parseInt(data[4].trim()), data[5].trim(),
                                    data[6].trim(), Double.parseDouble(data[7].trim())
                            ));
                            break;
                        case "MusicAlbum":
                            mediaList.add(new MusicAlbums(
                                    id, Integer.parseInt(data[2].trim()),
                                    data[3].trim(), data[4].trim(),
                                    Double.parseDouble(data[5].trim()),
                                    Integer.parseInt(data[6].trim()),
                                    Double.parseDouble(data[7].trim()),
                                    data[8].trim()
                            ));
                            break;
                        default:
                            System.out.println("Unknown type: " + typeField);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error parsing line: " + line);
                }
            }
        }
    }

    // ensures consistent handling of the type attribute from the CSV
    private String consistentData(String type) {
        switch (type.toLowerCase().replace(" ", "")) {
            case "movie":
                return "Movie";
            case "tvshow":
            case "tvshows":
                return "TVShow";
            case "videogame":
            case "videogames":
                return "VideoGame";
            case "musicalbum":
            case "musicalalbums":
                return "MusicAlbum";
            default:
                return "Unknown";
        }
    }

    // Parses the number of seasons from string field.
    private int searchSeasons(String seasonField) {
        String[] parts = seasonField.split(" ");
        try {
            return Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            return 0; 
        }
    }

    // Count all products in the CSV
    public int countTotalProducts() {
        return mediaList.size();
    }
    
    // Generic method that counts the number of media items in the mediaList that match the specified class type
    public <T> int countByType(Class<T> type) {
        int count = 0; 
        for (Media media : mediaList) { 
            if (type.isInstance(media)) { 
                count++; 
            }
        }
        return count; 
    }

    // Sort and search for oldest media in mediaList
    public Media findOldestProduct() {
        Media oldest = null;
        for (Media media : mediaList) {
            if (oldest == null || media.getReleaseYear() < oldest.getReleaseYear()) {
                oldest = media;
            }
        }
        return oldest;
    }

    // Sort and search for most popular album in mediaList
    public MusicAlbums findMostPopularAlbum() {
        MusicAlbums mostPopular = null;
        for (Media media : mediaList) {
            if (media instanceof MusicAlbums) {
                MusicAlbums album = (MusicAlbums) media;
                if (mostPopular == null || album.getGlobalSales() > mostPopular.getGlobalSales()) {
                    mostPopular = album;
                }
            }
        }
        return mostPopular;
    }

    // // Sort and search for most popular game in mediaList
    public VideoGames findMostPopularGame() {
        VideoGames mostPopular = null;
        for (Media media : mediaList) {
            if (media instanceof VideoGames) {
                VideoGames game = (VideoGames) media;
                if (mostPopular == null || game.getCopiesSold() > mostPopular.getCopiesSold()) {
                    mostPopular = game;
                }
            }
        }
        return mostPopular;
    }

    // search for most common age rating in mediaList
    public String findCommonAgeRating() {
        int countPG = 0, countPG13 = 0, countR = 0, countTVMA = 0, countTV14 = 0;

        for (Media media : mediaList) {
            String rating = null;
            if (media instanceof Movies) {
                rating = ((Movies) media).getRating();
            } else if (media instanceof TVShows) {
                rating = ((TVShows) media).getRating();
            }

            if (rating != null) {
                switch (rating.toUpperCase()) {
                    case "PG":
                        countPG++;
                        break;
                    case "PG-13":
                        countPG13++;
                        break;
                    case "R":
                        countR++;
                        break;
                    case "TV-MA":
                        countTVMA++;
                        break;
                    case "TV-14":
                        countTV14++;
                        break;
                }
            }
        }

        // Find the most common rating using counters
        int maxCount = Math.max(countPG, Math.max(countPG13, Math.max(countR, Math.max(countTVMA, countTV14))));
        if (maxCount == countPG) return "PG";
        if (maxCount == countPG13) return "PG-13";
        if (maxCount == countR) return "R";
        if (maxCount == countTVMA) return "TV-MA";
        if (maxCount == countTV14) return "TV-14";

        return null;
    }

    // search/sort for shortest movie in mediaList
    public Movies findShortestMovie() {
        Movies shortest = null;
        for (Media media : mediaList) {
            if (media instanceof Movies) {
                Movies movies = (Movies) media;
                if (shortest == null || movies.getDuration() < shortest.getDuration()) {
                    shortest = movies;
                }
            }
        }
        return shortest;
    }

    // search/sort for shortest album in mediaList
    public MusicAlbums findShortestMusicAlbum() {
        MusicAlbums shortest = null;
        for (Media media : mediaList) {
            if (media instanceof MusicAlbums) {
                MusicAlbums album = (MusicAlbums) media;
                if (shortest == null || album.getDuration() < shortest.getDuration()) {
                    shortest = album;
                }
            }
        }
        return shortest;
    }
}
