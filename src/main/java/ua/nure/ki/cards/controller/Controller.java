package ua.nure.ki.cards.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ua.nure.ki.cards.data.Result;
import ua.nure.ki.cards.data.TestSystem;
import ua.nure.ki.cards.service.GroupCategoryService;
import ua.nure.ki.cards.service.ResultService;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;

public class Controller {

    @FXML
    public ResourceBundle resources;

    @FXML
    public Label CENTR_result_out;

    @FXML
    private MenuItem MENU_find;

    @FXML
    private MenuBar sample_MenuBar;

    @FXML
    public void closeAction(ActionEvent a){
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
    public void findTestAction(ActionEvent b){

        sample_MenuBar.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/LoadUserResults.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root,1100, 600));
        Image windIcon=new Image("/images/icon3.png");
        stage.getIcons().add(windIcon);
        stage.setTitle("Uploading Test results");
        stage.show();

//        TestSystem ts = new TestSystem();
//        GroupCategoryService gcs= new GroupCategoryService();
//        ts.setSysGroupCategories(gcs.findAll());


//        ResultService rservice=new ResultService();
//        Result res=rservice.findById(1);
//      //  Resultout.append(res.toString());
//        CENTR_result_out.setText("Results:" + res.toString());
//        System.out.println(res.toString());

    }

    @FXML
    public void uploadZipAction(ActionEvent actionEvent){

        String zipFilePath="";
        JFileChooser fileopen = new JFileChooser();
        fileopen.setFileFilter(new FileFilter() {
            public String getDescription() {
                return "ZIP File (*.zip)";
            }

            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    String filename = f.getName().toLowerCase();
                    return filename.endsWith(".zip") || filename.endsWith(".rar") ;
                }
            }
        });


        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            zipFilePath=file.getPath();
            try {
                ZipFile zf=new ZipFile(zipFilePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    @FXML
    void initialize() {


    }

}
