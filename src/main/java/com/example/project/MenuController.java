package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
public class MenuController {
    @FXML
    Label numberLabel;
    @FXML
    Label UserName;
    @FXML
    Button tariffButton;
    @FXML Button aboutUs;
    @FXML
    private Button chooseTariffButton;
    @FXML
    private Button info;
    @FXML
    private URL location;
    @FXML
    private ResourceBundle resourceBundle;
    @FXML
    private Button logout;
    @FXML
    private Button rate;
    @FXML
    void initiliaze(){
        tariffButton.setOnAction(event -> {
            tariffButton.getScene().getWindow().hide();
            FXMLLoader loader =  new FXMLLoader();
            loader.setLocation(getClass().getResource("tariff.fxml"));
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
        chooseTariffButton.setOnAction(actionEvent -> {
            chooseTariffButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("chooseTariff.fxml"));
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
        info.setOnAction(actionEvent -> {
            info.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("myInfo.fxml"));
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

        logout.setOnAction(actionEvent -> {
            logout.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("b.fxml"));
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

        UserName.setOnMouseMoved(mouseEvent -> {
            loginController loginController = new loginController();
            UserName.setText("Welcome "+loginController.Clogin+"!");
        });
        aboutUs.setOnAction(actionEvent -> {
            aboutUs.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("aboutUs.fxml"));
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
        rate.setOnAction(actionEvent -> {
            rate.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("rate.fxml"));
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

