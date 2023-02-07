package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class complainController implements Initializable {
    @FXML
    private TextField complainTextField;
    @FXML
    private Button rate;
    @FXML
    private Label reasonLabel;
    @FXML
    private Button menu;
    @FXML
    private ChoiceBox<String> reasonOfComplain;
    @FXML
    private Button submit;
    @FXML
    private ImageView edit;
    @FXML
    void initiliaze(){



        submit.setOnAction(actionEvent -> {
            databaseHAndler databaseHAndler = new databaseHAndler();
            String reasonishka = reasonLabel.getText();
            reasonLabel.setOpacity(1);
            System.out.println(reasonishka);
            String complainka = complainTextField.getText();
            System.out.println(complainka);
            complain complain = new complain(reasonishka,complainka);
            databaseHAndler.addComplain(complain);
            reasonLabel.setText("It's been sent thank you!");

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
        menu.setOnAction(actionEvent -> {
            rate.getScene().getWindow().hide();
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

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addComplain();
        reasonOfComplain.setOnAction(this::net);
    }

    private void net(ActionEvent actionEvent) {
        String da = reasonOfComplain.getValue();
        reasonLabel.setText(da);

    }

    private void addComplain() {
        ArrayList<String>complains = new ArrayList<>();
        complains.add("Internet is slow");
        complains.add("Connection is unstable");
        complains.add("Periodically money is taken from my balance");
        complains.add("Changing the terms of use of services without my knowledge");
        complains.add("Other");
        reasonOfComplain.getItems().addAll(complains);
    }
}
