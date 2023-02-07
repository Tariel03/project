package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tariffController {
    @FXML
    private TableView <Tariff> tariffTableView;
    @FXML
    private TableColumn<Tariff,String> name;
    @FXML
    private TableColumn<Tariff,String> price;
    @FXML
    private TableColumn<Tariff,String> calls;
    @FXML
    private TableColumn<Tariff,String> internet;
    @FXML
    private TableColumn<Tariff,String> duration;
    @FXML
    private Button tableCreater;
    @FXML
    private Button toMenu;
    @FXML
    void initiliaze(){
        tableCreater.setOnAction(event -> {
            try {
                chooseTariff();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        toMenu.setOnAction(event -> {
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


    private void chooseTariff() throws SQLException {
        ObservableList<Tariff> tariffObservableList = FXCollections.observableArrayList();
        databaseHAndler databaseHandler = new databaseHAndler();
        ResultSet result = databaseHandler.chooseTariff();

        while (true) {
            try {
                if (!result.next())
                    break;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            tariffObservableList.add(new Tariff(result.getString("name"),
                    result.getString("price"),
                    result.getString("calls"),
                    result.getString("duration"),
                    result.getString("internet")));

        }
        name.setCellValueFactory(new PropertyValueFactory<Tariff, String>("name"));
        price.setCellValueFactory(new PropertyValueFactory<Tariff, String>("price"));
        duration.setCellValueFactory(new PropertyValueFactory<Tariff, String>("duration"));
        calls.setCellValueFactory(new PropertyValueFactory<Tariff, String>("calls"));
        internet.setCellValueFactory(new PropertyValueFactory<Tariff, String>("internet"));
        tariffTableView.setItems(tariffObservableList);
    }




}