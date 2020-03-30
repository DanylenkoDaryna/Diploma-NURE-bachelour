package ua.nure.ki.cards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import ua.nure.ki.cards.data.Result;
import ua.nure.ki.cards.service.ResultService;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("- - - Analysing Test System - - -");
        Image windIcon=new Image("/images/icon3.png");
        primaryStage.getIcons().add(windIcon);
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
