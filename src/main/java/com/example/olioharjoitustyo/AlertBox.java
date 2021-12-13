package com.example.olioharjoitustyo;
/**
 * Alert Boxes when adding new files and saving the file, error box
 */

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class AlertBox {

    public static void displaySuccessfulAdd() throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Expense Added");
        stage.setMinWidth(300);

        Label label = new Label();
        label.setText("Expense is added successfully!");

        Button closeButton = new Button("Ok");
        closeButton.setOnAction(e-> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void displayFileIsSaved() throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Save the file");
        stage.setMinWidth(300);

        Label label = new Label();
        label.setText("The file is saved successfully");

        Button closeButton = new Button("Ok");
        closeButton.setOnAction(e-> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void displayFileIsLoaded() throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Load the file");
        stage.setMinWidth(300);

        Label label = new Label();
        label.setText("The file is loaded successfully");

        Button closeButton = new Button("Ok");
        closeButton.setOnAction(e-> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void displayAbout() throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("About");
        stage.setMinWidth(300);

        Label label = new Label();
        label.setText("This a project made by Jere Korhonen.\nI will update this to be more user friendly.");

        Button closeButton = new Button("Ok");
        closeButton.setOnAction(e-> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }
    public static void displayError() throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Error");
        stage.setMinWidth(300);

        Label label = new Label();
        label.setText("Something went wrong");

        Button closeButton = new Button("Ok");
        closeButton.setOnAction(e-> stage.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
