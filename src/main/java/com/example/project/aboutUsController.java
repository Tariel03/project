package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class aboutUsController {
    @FXML
    private Button menu;
    @FXML
    void initiliaze(){
        menu.setOnAction(actionEvent -> {
            menu.getScene().getWindow().hide();
            FXMLLoader loader =  new FXMLLoader();
            loader.setLocation(getClass().getResource("Menu.fxml"));
            try {
                loader.load();

            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
    }
}
