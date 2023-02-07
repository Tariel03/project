package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

public class signUpHandler {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private PasswordField myPassWordField;
    @FXML
    private PasswordField myPassWordFieldChecking;
    @FXML
    TextField myTextField;
    @FXML
    private Button mySignUpButton;
    @FXML
    TextField numberTextField;
    @FXML
    TextField nameTextField;
    @FXML
    private Label success;

    public void switchToLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("b.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void initialize() {
        mySignUpButton.setOnAction(event -> {
            signUpNewUser();
            try {
                Parent root = FXMLLoader.load(getClass().getResource("b.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    private void signUpNewUser() {
        databaseHAndler dbHandler = new databaseHAndler();
        String login = myTextField.getText();
        String password = myPassWordField.getText();
        String name = nameTextField.getText();
        String number = numberTextField.getText();
        User user = new User(login,password,name,number);
        dbHandler.signUpUser(user);
        success.setOpacity(1);
        success.setText("You have successfully sign up,now move to press on login button!");



    }

}




