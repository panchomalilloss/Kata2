package software.ulpgc.kata2;

import software.ulpgc.kata2.io.RemoteMovieLoader;
import software.ulpgc.kata2.model.Movie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new RemoteMovieLoader().loadAll();
        System.out.println(movies.size());
    }
}
