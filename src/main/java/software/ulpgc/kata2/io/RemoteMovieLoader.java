package software.ulpgc.kata2.io;

import software.ulpgc.kata2.model.Movie;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class RemoteMovieLoader implements MovieLoader {

    @Override
    public List<Movie> loadAll(){
        try {
            return loadForm(new URL("https://datasets.imdbws.com/title.basics.tsv.gz"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Movie> loadForm(URL url) throws IOException {
        return loadForm(url.openConnection());
    }

    private List<Movie> loadForm(URLConnection connection) throws IOException {
        try (InputStream is = unzip(connection.getInputStream())) {
            return loadForm(is);
        }
    }

    private List<Movie> loadForm(InputStream is) throws IOException {
        return loadForm(toReader(is));
    }

    private List<Movie> loadForm(BufferedReader reader) throws IOException {
        MovieParser parser = new TSVMovieParser();
        List<Movie> list = new ArrayList<>();
        reader.lines();
        while (true){
            String line = reader.readLine();
            if (line == null) break;
            list.add(parser.parse(line));
        }
        return list;
    }

    private BufferedReader toReader(InputStream is) {
        return new BufferedReader(new InputStreamReader(is));
    }

    private InputStream unzip(InputStream inputStream ) throws IOException {
        return new GZIPInputStream(new BufferedInputStream(inputStream, 4096));
    }
}
