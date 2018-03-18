package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.controllers.MainView;

public class Main extends Application {
    public static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane myPane = (AnchorPane) FXMLLoader.load(getClass().getResource
                ("controllers/fxml/LoginView.fxml"));
        Scene myScene = new Scene(myPane);

        mainStage = primaryStage;

        primaryStage.setTitle("WawVote");
        primaryStage.setScene(myScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
