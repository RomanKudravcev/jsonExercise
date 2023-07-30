package jsonfun;

import model.Movie;
import model.Genre;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Create an instance of genre and film
        Genre genre = new Genre("horror");
        Movie movie1 = new Movie(0, "Barbie", 11, genre);

        // Initialize the JSONConverter and specify path for JSON output file
        JSONConverter jsonConverter = new JSONConverter();
        Path outputPath = Paths.get("src/output/output.json");

        // Convert model.Film object to JSON and save it to the output file
        jsonConverter.convertObjectToJSON(movie1, outputPath);


        // Convert JSON file to model.Film object
        File inputFile = new File("src/main/resources/movies.json");
        Movie movie2 = jsonConverter.convertJSONToObject(Movie.class, inputFile);

        // Display the converted model.Film object
        System.out.println(movie2.toString());
    }
}
