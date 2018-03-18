package sample.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import sample.Main;

import java.io.File;
import java.io.IOException;

public class LoginViewController {

    @FXML
    public void scan() throws IOException {
        System.out.println(new File("").getPath());
        AnchorPane myPane = (AnchorPane) FXMLLoader.load(getClass().getResource
                ("fxml/MainView.fxml"));
        Scene myScene = new Scene(myPane);

        Main.mainStage.setScene(myScene);
    }

    @FXML
    public void manual() throws IOException {
        AnchorPane myPane = (AnchorPane) FXMLLoader.load(getClass().getResource
                ("fxml/ManualDataInputView.fxml"));
        Scene myScene = new Scene(myPane);

        Main.mainStage.setScene(myScene);
    }

}
