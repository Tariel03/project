package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.project.loginController.Clogin;
import static com.example.project.loginController.Cpassword;

public class forgotPassword {

    @FXML
    private Label hello;
    @FXML
    private TextField numberTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField loginTextField;
    @FXML
    private Button submit;
    @FXML
    private Button Menu;

    @FXML
    void initiliaze(){
        submit.setOnAction(actionEvent -> {
            changePassword();
        });
        Menu.setOnAction(event -> {
            Menu.getScene().getWindow().hide();
            FXMLLoader loader =  new FXMLLoader();
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



    }

    private void changePassword() {
        String number = numberTextField.getText();
        String login = loginTextField.getText();
        String name = nameTextField.getText();
        if (number.length() >= 1 && login.length() >= 1 && name.length() >= 1) {
            databaseHAndler databaseHAndler = new databaseHAndler();
            User user = new User();
            ResultSet resultSet = databaseHAndler.getTariff();
            String password = "";
            while (true) {
                try {
                    if (!resultSet.next()) {
                        break;
                    } else if (resultSet.getString("login").equals(login) && resultSet.getString("number").equals(number) && resultSet.getString("name").equals(name)) {
                        password = resultSet.getString("password");
                    } else {
                        continue;
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if (!password.equals("") && password.length()>=1) {
                hello.setText("Your password is " + password + "\n" + "Please do not it forget anymore");
                System.out.println(password);
            }else {
                Shake UserLogin = new Shake(loginTextField);
                Shake UserPassword = new Shake(numberTextField);
                Shake UserName = new Shake(nameTextField);
                UserName.playAnim();
                UserLogin.playAnim();
                UserPassword.playAnim();
                hello.setText("One or more of the given info are wrong!"+"\n"+"Try again!");
            }
        } else {
            Shake UserLogin = new Shake(loginTextField);
            Shake UserPassword = new Shake(numberTextField);
            Shake UserName = new Shake(nameTextField);
            UserName.playAnim();
            UserLogin.playAnim();
            UserPassword.playAnim();

        }
    }

}
