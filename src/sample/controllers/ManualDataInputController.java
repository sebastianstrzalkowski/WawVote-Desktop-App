package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.Main;

import java.io.IOException;

public class ManualDataInputController {

    @FXML
    TextField name;

    @FXML
    TextField pesel;

    @FXML
    TextField numer_dowodu;

    @FXML
    public boolean waliduj(){
        boolean correct = true;
        if(numer_dowodu.getText().matches("[A-Z]{3}[0-9]{6}")) {
            numer_dowodu.setStyle("-fx-border-color: green");
        } else {
            numer_dowodu.setStyle("-fx-border-color: red");
            correct = false;
        }

        if(pesel.getText().matches("[0-9]{11}")) {
            pesel.setStyle("-fx-border-color: green");
        } else {
            pesel.setStyle("-fx-border-color: red");
            correct = false;
        }

        if(name.getText().matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
            name.setStyle("-fx-border-color: green");
        } else {
            name.setStyle("-fx-border-color: red");
            correct = false;
        }

        return correct;
    }

    @FXML
    public void zapisz() throws IOException {
        if(waliduj()) {
            AnchorPane myPane = (AnchorPane) FXMLLoader.load(getClass().getResource
                    ("fxml/MainView.fxml"));
            Scene myScene = new Scene(myPane);

            Main.mainStage.setScene(myScene);
        }

    }

}
