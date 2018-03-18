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
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pl.waw.wawvote.utils.MultichainAPI;
import sample.utils.MultichainConnection;
import sample.utils.MultichainConnectionI;

import javax.management.Notification;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MainView implements Initializable {




    public ComboBox candidateBox = new ComboBox();
    public BarChart<String, Integer> chartResult;
    public MultichainConnection multichainConnection;
    public XYChart.Series series1 = new XYChart.Series();
    public final CategoryAxis xAxis = new CategoryAxis();
    public final NumberAxis yAxis = new NumberAxis();

    public ObservableList<String> candidateList = FXCollections.observableArrayList(
            new String("Paweł Rabiej"),
            new String("Rafał Trzaskowski"),
            new String("Piotr Lorey-Marzec"),
            new String("Jarosław Krajewski"),
            new String("Paweł Tanajno"),
            new String("Hanna Gronkiewicz-Waltz")

    );



    public void initialize(URL location, ResourceBundle resources) {


        multichainConnection = new MultichainConnection();

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
        candidateBox.getItems().addAll(candidateList);

    }

    public void voteButton(ActionEvent actionEvent) {

        int candidate = candidateBox.getSelectionModel().getSelectedIndex();
        System.out.println(candidate);
        multichainConnection.vote(candidate);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Udało się zagłosować");
        alert.showAndWait();
    }

    public void checkResult(ActionEvent actionEvent) {


        Map<Integer, Long> counters = multichainConnection.getResults();

        series1 = new XYChart.Series();

        System.out.println(counters);
        series1.setName("2018");
        series1.getData().add(new XYChart.Data(candidateList.get(0), counters.containsKey(0)?counters.get(0):0));
        series1.getData().add(new XYChart.Data(candidateList.get(1), counters.containsKey(1)?counters.get(1):0));
        series1.getData().add(new XYChart.Data(candidateList.get(2), counters.containsKey(2)?counters.get(2):0));
        series1.getData().add(new XYChart.Data(candidateList.get(3), counters.containsKey(3)?counters.get(3):0));
        series1.getData().add(new XYChart.Data(candidateList.get(4), counters.containsKey(4)?counters.get(4):0));
        series1.getData().add(new XYChart.Data(candidateList.get(5), counters.containsKey(5)?counters.get(5):0));
        chartResult.getData().setAll(series1);
    }
}
