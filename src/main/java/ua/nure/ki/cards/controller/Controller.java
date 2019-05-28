package ua.nure.ki.cards.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.io.File;

public class Controller {

    public void closeAction(ActionEvent event){
        Platform.exit();
        System.exit(0);
    }

    public void uploadZipAction(ActionEvent actionEvent){
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
        }
    }

}
