package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Movie;

import java.io.IOException;

public interface MovieParser {
    Movie parse(String str) throws IOException;
}
