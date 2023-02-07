package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class rateController implements  Initializable{
    @FXML
    private Button menu;
    @FXML
    private Button submit;
    @FXML
    private TextField review;
    @FXML
    private ChoiceBox<String> rate;
    @FXML
    private Label rateLabel;
    @FXML
    private Label complainLabel;

    @FXML
    private Label reviewLabel;
    @FXML
    private Label ratingofApp;


    @FXML
    void initiliaze() {
        menu.setOnAction(actionEvent -> {
            menu.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
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

        submit.setOnAction(actionEvent -> {
            addRate();
        });
        ratingofApp.setOnMouseClicked(mouseEvent -> {
            getRate();
        });
        complainLabel.setOnMouseClicked(mouseEvent -> {
            complainLabel.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("complain.fxml"));
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

    private void getRate() {
        Double counter = 0.0;
        double allrate = 0;
        ArrayList<Integer>quantityRate = new ArrayList<>();
        databaseHAndler databaseHAndler = new databaseHAndler();
        ResultSet resultSet = databaseHAndler.getRating();
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }else {
                    quantityRate.add(Integer.valueOf(resultSet.getString("rating")));
                    allrate += Integer.parseInt(resultSet.getString("rating"));
                    counter++;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            String  currentRate = String.valueOf(allrate/counter);
            String allOfRates = String.valueOf(quantityRate.size());
            ratingofApp.setText(String.valueOf("  Rate of the service : "+ currentRate  +"\n" +"\n" + "  Overall ranking: "+allOfRates));
        }

    }


    private void addRate() {
        databaseHAndler databaseHAndler = new databaseHAndler();
        String rating = rateLabel.getText();
        System.out.println(rating);
        String reviewshka = review.getText();
        System.out.println(reviewshka);
        Rate rate = new Rate(rating,reviewshka);
        databaseHAndler.rating(rate);
        reviewLabel.setText("It's been sent thank you!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ratings();
        rate.setOnAction(this::da);
    }

    private void da(ActionEvent actionEvent) {
        String ratingishka = rate.getValue().toString();
        rateLabel.setText(ratingishka);
    }

    private void ratings() {
        ArrayList<String> ratingList = new ArrayList<>();
        for(int i = 1;i<=10;i++){
            ratingList.add(String.valueOf(i));
        }
        rate.getItems().addAll(ratingList);
    }


}
