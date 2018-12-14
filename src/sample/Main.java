package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

import static sample.CVSReader.readAppsFromCSV;

public class Main extends Application {

    final static String incomplete = "Incomplete";
    final static String pending = "Pending Fitness Interview";
    final static String review = "Under Review";
    final static String approved = "Approved";
    final static String denied = "Denied";
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final StackedBarChart<String, Number> sbc =
            new StackedBarChart<String, Number>(xAxis, yAxis);
    final XYChart.Series<String, Number> series1 =
            new XYChart.Series<String, Number>();

   static double a = 0;
   static double b = 0;
   static double c = 0;
   static double d = 0;
   static double e = 0;
   static int aa = 0;
   static int bb = 0;
   static int cc = 0;
   static int dd = 0;
   static int ee = 0;

    @Override
    public void start(Stage stage) {

        stage.setTitle("Driver Apps Stats Bar Chart");
        sbc.setTitle("Average Missing Procedures for Corresponding App Statuses");
        xAxis.setLabel("Status");
        xAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(incomplete, pending, review, approved, denied)));
        yAxis.setLabel("Value");
        series1.setName("Average Missing Procedures (Defensive Driving, Driving Exam, Medical Clearance)");
        series1.getData().add(new XYChart.Data<String, Number>(incomplete, a/aa));
        series1.getData().add(new XYChart.Data<String, Number>(pending, b/bb));
        series1.getData().add(new XYChart.Data<String, Number>(review, c/cc));
        series1.getData().add(new XYChart.Data<String, Number>(approved, d/dd));
        series1.getData().add(new XYChart.Data<String, Number>(denied, e/ee));
        Scene scene = new Scene(sbc, 800, 600);
        sbc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        List<App> Apps = readAppsFromCSV("src/driver.csv");

        for (App z : Apps) {
            if(z.getStatus().equals("Incomplete")){
                a+=z.getComplete();
                aa++;
            } else if(z.getStatus().equals("Pending Fitness Interview")) {
                b+=z.getComplete();
                bb++;
            } else if(z.getStatus().equals("Under Review")) {
                c+=z.getComplete();
                cc++;
            } else if(z.getStatus().equals("Approved - License Issued")){
                d+=z.getComplete();
                dd++;
            } else {
                e+=z.getComplete();
                ee++;
            }
        }

        launch(args);
    }
}
