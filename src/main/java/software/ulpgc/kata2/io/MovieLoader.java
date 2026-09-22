package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Movie;

import java.net.MalformedURLException;
import java.util.List;

public interface MovieLoader {
    List<Movie> loadAll() throws MalformedURLException;
}
