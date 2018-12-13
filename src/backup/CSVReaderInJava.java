package backup;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Java program to read CSV file in Java. In this program we will read
 * list of Apps stored in CSV file as comma separated values.
 *
 * @author WINDOWS 8
 *
 */
public class CSVReaderInJava {

    public static void main(String... args) {
        List<App> Apps = readDriversFromCSV("src/driver.csv");

        // let's print all the person read from CSV file
        for (App b : Apps) {
            System.out.println(b);
        }
    }

    private static List<App> readDriversFromCSV(String fileName) {
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

                App App = createSchool(attributes);

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

    private static App createSchool(String[] metadata) {
        String status = metadata[3];
        String dd = metadata[7];
        String de = metadata[8];
        String mc = metadata[9];
        // create and return backup.App of this metadata
        return new App(status, dd, de, mc);
    }

}

class App {
    private String status;
    private int missing = 0;

    public App(String status, String dd, String de, String mc) {
        this.status = status;

        if(dd.equalsIgnoreCase("Needed")){
            missing++;
        }
        if(de.equalsIgnoreCase("Needed")){
            missing++;
        }
        if(mc.equalsIgnoreCase("Needed")){
            missing++;
        }
    }

    public String getStatus(){
        return status;
    }

    public int getMissing(){
        return missing;
    }

    @Override
    public String toString() {
        return "[ " + status + " ]" + " Missing Procedures: " + missing;
    }

}
