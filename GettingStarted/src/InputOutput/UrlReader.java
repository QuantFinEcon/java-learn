package InputOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlReader {
    public static void main(String[] args) throws Exception {
        String urlString = "https://people.sc.fsu.edu/~jburkardt/data/csv/hurricanes.csv";

        // create the url
        URL url = new URL(urlString);

        // open the url stream, wrap it an a few "readers"
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

        try {
            // write the output to stdout
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            if (reader != null) {
                // close our reader
                reader.close();
            }
        }
    }
}