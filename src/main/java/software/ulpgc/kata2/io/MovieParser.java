package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Movie;

public interface MovieParser {
    Movie parse(String str);
}
