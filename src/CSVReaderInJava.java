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
        List<App> Apps = readSchoolsFromCSV("src/driver.csv");

        // let's print all the person read from CSV file
        for (App b : Apps) {
            System.out.println(b);
        }
    }

    private static List<App> readSchoolsFromCSV(String fileName) {
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

                // adding App into ArrayList
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
        // create and return App of this metadata
        return new App(status, dd,de);
    }

}

class App {
    private String status;
    private boolean dd = false;
    private boolean de = false;

    public App(String status, String dd, String de) {
        this.status = status;

        if(dd.equals("complete")){
            this.dd = true;
        }
        if(de.equals("complete")){
            this.de = true;
        }
    }

    public String getStatus(){
        return status;
    }

    public boolean getDD(){
        return dd;
    }

    public boolean getDE(){
        return de;
    }

    @Override
    public String toString() {
        return "[ " + status + " ]" + " DD: " + dd + ", DE: " + de;
    }

}
