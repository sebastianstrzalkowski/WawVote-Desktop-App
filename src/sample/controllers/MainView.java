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
import sample.utils.MultichainConnectionI;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class MainView implements Initializable {




    public ComboBox candidateBox = new ComboBox();
    public BarChart chartResult;

    private ObservableList<String> candidateList = FXCollections.observableArrayList(
            new String("Paweł Rabiej"),
            new String("Rafał Trzaskowski"),
            new String("Piotr Lorey-Marzec"),
            new String("Jarosław Krajewski"),
            new String("Paweł Tanajno"),
            new String("Hanna Gronkiewicz-Waltz")

    );


    public void initialize(URL location, ResourceBundle resources) {

        candidateBox.getItems().addAll(candidateList );


        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> chartResult =
                new BarChart<String,Number>(xAxis,yAxis);
        chartResult.setTitle("Country Summary");
        xAxis.setLabel("Kandydaci");
        yAxis.setLabel("Ilość głosów");

    }

    public void voteButton(ActionEvent actionEvent) {
    }

    public void checkResult(ActionEvent actionEvent) {

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(candidateList.get(0), 30));
        series1.getData().add(new XYChart.Data(candidateList.get(1), 20));
        series1.getData().add(new XYChart.Data(candidateList.get(2), 11));
        series1.getData().add(new XYChart.Data(candidateList.get(3), 5));
        series1.getData().add(new XYChart.Data(candidateList.get(4), 17));
        series1.getData().add(new XYChart.Data(candidateList.get(5), 17));
        chartResult.getData().addAll(series1);
    }
}
