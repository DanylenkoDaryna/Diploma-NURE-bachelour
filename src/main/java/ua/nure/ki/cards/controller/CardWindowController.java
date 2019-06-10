package ua.nure.ki.cards.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ua.nure.ki.cards.data.GroupCategory;
import ua.nure.ki.cards.service.GroupService;
import ua.nure.ki.cards.service.ResultService;

import java.io.IOException;

public class CardWindowController {

    @FXML
    private MenuBar menu_bar3;

    @FXML
    void closeAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void helpAbout(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/about.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root,525, 340));
        stage.show();
    }

    @FXML
    void goInMainWindow(ActionEvent event) {

        menu_bar3.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/LoadUserResults.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 1100, 600));
        Image windIcon = new Image("/images/icon3.png");
        stage.getIcons().add(windIcon);
        stage.setTitle("Uploading Test results");
        stage.show();


    }

    @FXML
    void initialize() {
    }
}
