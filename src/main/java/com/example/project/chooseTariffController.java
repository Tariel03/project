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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.project.loginController.Clogin;
import static com.example.project.loginController.Cpassword;

public class chooseTariffController implements Initializable {
    @FXML
    private ChoiceBox<String> tariffs;
    @FXML
    private Button toMenu;
    @FXML
    private TextField id;
    @FXML
    private Label nameofTariff;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tariffs();
        tariffs.setOnAction(this::setAddTariff);
    }

    private void tariffs() {
        databaseHAndler databaseHAndler = new databaseHAndler();
        ResultSet result = databaseHAndler.chooseTariff();
        ArrayList<String> tariff = new ArrayList<>();
        while (true) {
            try {
                if (!result.next())
                    break;
                else
                    tariff.add(result.getString("name"));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        tariffs.getItems().addAll(tariff);
        System.out.println(tariff);
    }


    @FXML
    void initiliazed(){
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

    }
    public void setAddTariff(ActionEvent event){
       databaseHAndler databaseHAndler = new databaseHAndler();
       int idishka = 0;
        ResultSet resultSet = databaseHAndler.getTariff();
        ArrayList<String> info = new ArrayList<>();
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
    String tariffsValue = tariffs.getValue();
    System.out.println(tariffsValue);
    nameofTariff.setText("Your tariff is -"+tariffsValue+"!");
    User user = new User();
    user.setTariff(tariffsValue);
    int ID = Integer.parseInt(String.valueOf(idishka));
    user.setId(ID);
    databaseHAndler.addTariff(user);






//    databaseHAndler databaseHAndler = new databaseHAndler();
//    String tariffsValue = tariffs.getValue();
//    System.out.println(tariffsValue);
//    nameofTariff.setText("Your tariff is -"+tariffsValue+"!");
//    User user = new User();
//    user.setTariff(tariffsValue);
//    int ID = Integer.parseInt(id.getText());
//    user.setId(ID);
//    databaseHAndler.addTariff(user);
    }


}
