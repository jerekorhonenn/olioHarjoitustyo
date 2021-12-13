package com.example.olioharjoitustyo.controllers;
/**
 *Button actions: Load file, save file, about info, open a new window
 */
import com.example.olioharjoitustyo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ViewController {

    @FXML
    public void openChoiceWindow(MouseEvent event) throws Exception {
        ChoiceWindow.displays();
    }

    @FXML
    public void saveTheFileButton(ActionEvent event) throws Exception {
        try{
            AddExpensesController.writeToFile();
            AlertBox.displayFileIsSaved();
        } catch(Exception e){
            AlertBox.displayError();
        }
    }
    @FXML
    public void loadTheFileButton(ActionEvent event) throws Exception {
        try{
            AddExpensesController.readFromFile();
            AlertBox.displayFileIsLoaded();
        }catch (Exception e){
            AlertBox.displayError();
        }
    }
    public void aboutButton(ActionEvent actionEvent) throws IOException {
        AlertBox.displayAbout();
    }


}
