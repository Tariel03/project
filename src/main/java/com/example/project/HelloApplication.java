package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("b.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Customer!");
        stage.setScene(scene);
        stage.show();stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);
        });
    }

    public static void main(String[] args) {
        launch();
    }

    public void logout(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are to exit");
        alert.setContentText("Do you want to save before exiting?: ");
        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You have successfully exited!");
            stage.close();
        }

    }
}