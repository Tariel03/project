package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class loginController {
    @FXML
    TextField myTextField;
    @FXML
    PasswordField myPasswordField;
    @FXML
    Button SignupButton;
    @FXML
    Button Submit;
    @FXML
    private URL location;
    @FXML
    private ResourceBundle resourceBundle;
    @FXML
    private Label loginLabel;
    @FXML
    private Label forgotPassword;
    public static String Clogin = "";
    public static String Cpassword = "";
    User user = new User();
    String userName = "Welcome" +" tariel!";
    @FXML
    void initialize() {
        SignupButton.setOnAction(event -> {
            SignupButton.getScene().getWindow().hide();
            FXMLLoader loader =  new FXMLLoader();
            loader.setLocation(getClass().getResource("a.fxml"));
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
        Submit.setOnAction(event -> {
            String loginText = myTextField.getText().trim();
            String loginPassword = myPasswordField.getText().trim();
            Clogin  = loginText;
            Cpassword = loginPassword;
            user.setName(loginText);
            if(!loginText.equals("") && !loginPassword.equals(" "))
                loginUser(loginText,loginPassword);
            else
                System.out.println("Login and password are empty");
        });
        forgotPassword.setOnMouseClicked(mouseEvent -> {
            SignupButton.getScene().getWindow().hide();
            FXMLLoader loader =  new FXMLLoader();
            loader.setLocation(getClass().getResource("forgotPassword.fxml"));
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

    private void loginUser(String loginText, String loginPassword) {
        databaseHAndler dbHandler = new databaseHAndler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(loginPassword);
        ResultSet resultSet = dbHandler.getUser(user);

        int counter = 0;
        while (true){
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter>= 1){
            System.out.println("Hallo");
            Submit.getScene().getWindow().hide();
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

        }else {
            Shake UserLogin = new Shake(myTextField);
            Shake UserPassword = new Shake(myPasswordField);
            UserLogin.playAnim();
            UserPassword.playAnim();

        }


    }

}