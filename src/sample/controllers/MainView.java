package sample.controllers;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pl.waw.wawvote.utils.MultichainAPI;
import sample.utils.MultichainConnectionI;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainView implements Initializable {




    private ComboBox candidateBox = new ComboBox();
    public BarChart<String, Integer> chartResult;
    private MultichainAPI multichainAPI;
    private XYChart.Series series1 = new XYChart.Series();
    private final CategoryAxis xAxis = new CategoryAxis();
    private final NumberAxis yAxis = new NumberAxis();

    private ObservableList<String> candidateList = FXCollections.observableArrayList(
            new String("Paweł Rabiej"),
            new String("Rafał Trzaskowski"),
            new String("Piotr Lorey-Marzec"),
            new String("Jarosław Krajewski"),
            new String("Paweł Tanajno"),
            new String("Hanna Gronkiewicz-Waltz")

    );


    public void initialize(URL location, ResourceBundle resources) {


        //multichainAPI = new MultichainAPI();

        xAxis.setLabel("Kandydat");
        yAxis.setLabel("Ilość głosów");

        series1 = new XYChart.Series();
        series1.setName("2018");
        series1.getData().add(new XYChart.Data(candidateList.get(0), 0));
        series1.getData().add(new XYChart.Data(candidateList.get(1), 0));
        series1.getData().add(new XYChart.Data(candidateList.get(2), 0));
        series1.getData().add(new XYChart.Data(candidateList.get(3), 0));
        series1.getData().add(new XYChart.Data(candidateList.get(4), 0));
        series1.getData().add(new XYChart.Data(candidateList.get(5), 0));

        chartResult.getData().addAll(series1);


    }

    public void voteButton(ActionEvent actionEvent) {

        //int candidate = candidateBox.getSelectionModel().getSelectedIndex();
        //multichainAPI.addToChain("stream1", "key1", candidate);

    }

    public void checkResult(ActionEvent actionEvent) {

        series1.setName("2018");
        series1.getData().add(new XYChart.Data(candidateList.get(0), 30));
        series1.getData().add(new XYChart.Data(candidateList.get(1), 20));
        series1.getData().add(new XYChart.Data(candidateList.get(2), 11));
        series1.getData().add(new XYChart.Data(candidateList.get(3), 5));
        series1.getData().add(new XYChart.Data(candidateList.get(4), 17));
        series1.getData().add(new XYChart.Data(candidateList.get(5), 17));
        chartResult.getData().setAll(series1);
    }
}
