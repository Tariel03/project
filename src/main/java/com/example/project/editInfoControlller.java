package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PipedReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.project.loginController.Clogin;
import static com.example.project.loginController.Cpassword;

public class editInfoControlller {
    @FXML
    private Button menu;
    @FXML
    private Button submit;
    @FXML
    private TextField nameField;
    @FXML
    private TextField numberField;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label nameLabel;
    @FXML
    private  Label numberLabel;
    @FXML
    private Label loginLabel;
    @FXML
    private Label  passwordLabel;

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
        nameLabel.setOnMouseClicked(mouseEvent -> {
            changeName();
        });
        numberLabel.setOnMouseClicked(mouseEvent -> {
            changeNumber();
        });
        loginLabel.setOnMouseClicked(mouseEvent -> {
            changeLogin();
        });
        passwordLabel.setOnMouseClicked(mouseEvent -> {
            changePassword();
        });
        submit.setOnAction(actionEvent -> {
            submit.getScene().getWindow().hide();
            FXMLLoader loader =  new FXMLLoader();
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

    }

    private void changePassword() {
        databaseHAndler databaseHAndler = new databaseHAndler();
        int idishka = 0;
        ResultSet resultSet = databaseHAndler.getTariff();
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }else if (resultSet.getString("login").equals(Clogin) && resultSet.getString("password").equals(Cpassword)){
                    idishka = resultSet.getInt("idnew_table");
                }else{
                    continue;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        User user = new User();
        int ID = Integer.parseInt(String.valueOf(idishka));
        user.setId(ID);
        String password = passwordField.getText();
        user.setPassword(password);
        Cpassword = password;
        databaseHAndler.changePassword(user);
    }

    private void changeLogin() {
        databaseHAndler databaseHAndler = new databaseHAndler();
        int idishka = 0;
        ResultSet resultSet = databaseHAndler.getTariff();
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }else if (resultSet.getString("login").equals(Clogin) && resultSet.getString("password").equals(Cpassword)){
                    idishka = resultSet.getInt("idnew_table");
                }else{
                    continue;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        User user = new User();
        int ID = Integer.parseInt(String.valueOf(idishka));
        user.setId(ID);
        String login = loginField.getText();
        user.setLogin(login);
        Clogin = login;
        databaseHAndler.changeLogin(user);
    }

    private void changeNumber() {
        databaseHAndler databaseHAndler = new databaseHAndler();
        int idishka = 0;
        ResultSet resultSet = databaseHAndler.getTariff();
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }else if (resultSet.getString("login").equals(Clogin) && resultSet.getString("password").equals(Cpassword)){
                    idishka = resultSet.getInt("idnew_table");
                }else{
                    continue;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        User user = new User();
        int ID = Integer.parseInt(String.valueOf(idishka));
        user.setId(ID);
        String number  = numberField.getText();
        user.setNumber(number);
        databaseHAndler.changeNumber(user);
    }

    private void changeName() {
        databaseHAndler databaseHAndler = new databaseHAndler();
        int idishka = 0;
        ResultSet resultSet = databaseHAndler.getTariff();
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }else if (resultSet.getString("login").equals(Clogin) && resultSet.getString("password").equals(Cpassword)){
                    idishka = resultSet.getInt("idnew_table");
                }else{
                    continue;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        User user = new User();
        int ID = Integer.parseInt(String.valueOf(idishka));
        user.setId(ID);
        String name  = nameField.getText();
        user.setName(name);
        databaseHAndler.changeName(user);
    }


}
