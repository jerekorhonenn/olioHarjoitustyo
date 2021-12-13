package com.example.olioharjoitustyo;
/**
 * Opens Expense add window
 */
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

//Opens a new window where user can add new expenses
public class AddExpensesWindow {
    public static void display()throws Exception{
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addExpensesView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
