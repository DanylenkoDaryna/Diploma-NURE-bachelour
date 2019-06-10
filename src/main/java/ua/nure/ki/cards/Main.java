package ua.nure.ki.cards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ua.nure.ki.cards.data.Result;
import ua.nure.ki.cards.service.ResultService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        primaryStage.setTitle("- - - TestSystem - - -");
        Image windIcon=new Image("/images/icon3.png");
        primaryStage.getIcons().add(windIcon);
        primaryStage.setScene(new Scene(root, 1100, 600));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);

//        LocalDateTime date = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd h:m:s");
//        String text = date.format(formatter);
//

    }




}
