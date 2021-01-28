package edu.isu.cs.cs2263;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class App extends Application {


    private static Object List;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("First JavaFX Application");

        Label label = new Label("Data");
        Button button = new Button("Load Data");




        ObservableList<String> studentNames = FXCollections.observableArrayList( IOManager.readData(""));
        ListView<String> students = new ListView<String>(studentNames);
        students.setMaxSize(420, 160);



        button.setOnAction(value -> {
            //get info for taylor when button pressed
            //students
            //ListView<String> studentNamesS = new ListView<String>(studentNames);

            label.setText("Students ");

            VBox layout = new VBox(10);
            layout.setPadding(new Insets(5,505,5,5));
            layout.getChildren().addAll(label, students);
            Scene scene = new Scene((layout), 600, 400);
            stage.setScene(scene);
            stage.show();
        });



        students.setOnMousePressed(value -> {
            label.setText("Class Data");
            VBox layout = new VBox(10);
            layout.setPadding(new Insets(5,50,5,50));
            layout.getChildren().addAll(label, students);
            Scene scene = new Scene((layout), 600, 400);
            stage.setScene(scene);
            stage.show();
        });
        /*

         */

 //       ListView.

        VBox vbox = new VBox(button, label);



        Scene scene = new Scene(vbox, 600, 400);
        stage.setScene(scene);
        stage.show();

    }



    public static void main(String[] args) {

        Student Taylor = new Student ("Tate", "Bakers", new Course (1170,"Math","calculus"));
        Student Kyle = new Student ("Kyle", "Bakers", new Course (2270,"Math","calculus1"));
        Student Lily = new Student ("Lilly", "Bakers", new Course (1175,"Math","calculus2"));

        //Student[] students = {Taylor};
        //System.out.println("Taylor information:" + Taylor + "\n");

        IOManager.writeData(Lists.newArrayList(Kyle, Lily, Taylor));
        //IOManager.writeData("Kyle", Kyle);
        //IOManager.writeData("Lily", Lily);
        //IOManager.writeData("Taylor", Taylor);

        System.out.println("Students written to file.\n\n");

        Application.launch(args);

    }

}