package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Movie;

public class TSVMovieParser implements MovieParser {
    @Override
    public Movie parse(String str) {
        return parse(str.split("\t"));
    }

    private Movie parse(String[] split) {
        return new Movie(split[2], toInt(split[7]));
    }

    private int toInt(String s) {
        if(s.equals("\\N")) return -1;
        return Integer.parseInt(s);
    }

}
