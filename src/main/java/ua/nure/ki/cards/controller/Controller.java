package ua.nure.ki.cards.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

public class Controller {

    public void closeAction(ActionEvent event){
        Platform.exit();
        System.exit(0);
    }

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

}
