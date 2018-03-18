package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.controllers.MainView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane myPane = (AnchorPane) FXMLLoader.load(getClass().getResource
                ("controllers/fxml/MainView.fxml"));
        Scene myScene = new Scene(myPane);

        primaryStage.setTitle("WawVote");
        primaryStage.setScene(myScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
