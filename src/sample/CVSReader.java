package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CVSReader {
    public static List<App> readAppsFromCSV(String fileName) {
        List<App> Apps = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();
            line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                App App = createApp(attributes);

                // adding backup.App into ArrayList
                Apps.add(App);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return Apps;
    }

    public static App createApp(String[] metadata) {
        String status = metadata[3];
        String dd = metadata[7];
        String de = metadata[8];
        String mc = metadata[9];
        // create and return backup.App of this metadata
        return new App(status, dd, de, mc);
    }
}