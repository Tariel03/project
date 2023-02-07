package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.project.loginController.Clogin;
import static com.example.project.loginController.Cpassword;

public class myInfoController {
    @FXML
    private Label name;
    @FXML
    private Label login;
    @FXML
    private Label password;
    @FXML
    private Label number;
    @FXML
    private  Label tariff;
    @FXML
    private Button toMenu;
    @FXML
    private Button getInfo;
    @FXML
    private Button change;

    @FXML
    void initiliaze(){
        getInfo.setOnAction(actionEvent -> {
            SetInfo();

        });
        toMenu.setOnAction(actionEvent -> {
            toMenu.getScene().getWindow().hide();
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
        change.setOnAction(actionEvent -> {
            change.getScene().getWindow().hide();
            FXMLLoader loader =  new FXMLLoader();
            loader.setLocation(getClass().getResource("editInfo.fxml"));
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

    private void SetInfo() {
        databaseHAndler databaseHAndler = new databaseHAndler();
        ResultSet resultSet = databaseHAndler.getTariff();
        ArrayList<String> info = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                }else if (resultSet.getString("login").equals(Clogin) && resultSet.getString("password").equals(Cpassword)){
                    info.add(resultSet.getString("tariff"));
                    info.add(resultSet.getString("name"));
                    info.add(resultSet.getString("number"));
                    info.add(resultSet.getString("login"));
                    info.add(resultSet.getString("password"));

                }else{
                    continue;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(info);
            name.setText("Your name is : "+info.get(1));
            tariff.setText("Your current tariff is : "+info.get(0));
            password.setText("Your password is : "+info.get(4));
            login.setText("Your login is : "+info.get(3));
            number.setText("Your number is : "+info.get(2));


        }



//        ArrayList<String> tariffs = new ArrayList<>();
//        ArrayList<String> names = new ArrayList<>();
//        ArrayList<String> numbers = new ArrayList<>();
//        ArrayList<String> logins = new ArrayList<>();
//        ArrayList<String> passwords = new ArrayList<>();
//        databaseHAndler databaseHAndler = new databaseHAndler();
//        ResultSet resultSet = databaseHAndler.getTariff();
//
//        while (true) {
//            try {
//                if (!resultSet.next()) {
//                    break;
//                }else {
//                    tariffs.add(resultSet.getString("tariff"));
//                    names.add(resultSet.getString("name"));
//                    numbers.add(resultSet.getString("number"));
//                    logins.add(resultSet.getString("login"));
//                    passwords.add(resultSet.getString("password"));
//
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//        System.out.println(tariff);
//        System.out.println(names);
//        System.out.println(numbers);
//        System.out.println(logins);
//        System.out.println(passwords);
//        int Idishka = Integer.parseInt(IdtextField.getText());
//        int i = 0;
//        while (true){
//            if (i==Idishka){
//                name.setText("Your name is : "+names.get(i));
//                tariff.setText("Your current tariff is : "+tariffs.get(i));
//                password.setText("Your password is : "+passwords.get(i));
//                login.setText("Your login is : "+logins.get(i));
//                number.setText("Your number is : "+numbers.get(i));
//                break;
//            }
//            i++;
//        }


    }

}
