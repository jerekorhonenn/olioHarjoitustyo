package com.example.olioharjoitustyo.controllers;
/**
 *Choice window controller
 * BarGraph, TotalExpenses, Specific date expenses
 */
import com.example.olioharjoitustyo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Objects;

import static com.example.olioharjoitustyo.controllers.AddExpensesController.*;

public class ChoiceWindowController {
    @FXML
    private DatePicker summaryDatePicker;
    @FXML
    private TextField summarySum;
    @FXML
    private TextArea expenseLister;
    @FXML
    private TextField allExpenses;

    //User chooses the date and method shows the expenses of the day and prints all the expenses.
    public void summaryAction(ActionEvent event){
        //Set the date user selected
        LocalDate expenseDate = summaryDatePicker.getValue();
        //Modifies the expenseDate to String "12.12.2021"
        String formattedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(expenseDate);
        // Creates Paivamaara object
        Paivamaara day = new Paivamaara(formattedDate);
        //Clears the summary textField from previous info.
        summarySum.clear();
        //Sets teh new info using getSumOfExpensesDay method
        summarySum.appendText(AddExpensesController.getSumOfExpensesDay(day)+" €");
        //Use String Builder -> prints an array list
        //Clear old info
        expenseLister.clear();
        //Sets the titles
        expenseLister.appendText("Date\t\t\tCategory\t\tCost €\t\t\tComment\n-------------------------------------------------------------------\n");
        //Create String builder object -> use getExpensesDay method and gives the selected day as a parameter.
        StringBuilder test = AddExpensesController.getExpensesDay(day);
        expenseLister.appendText(test.toString());
    }
    //Opens window where you can add new expenses
    public void openAddExpensesWindow(MouseEvent mouseEvent) throws Exception {
        AddExpensesWindow.display();
    }
    //Calculates total expenses and writes it to the textField when button is pressed
    public void showAllExpenses(ActionEvent actionEvent) {
        allExpenses.clear();
        String sumOfExpenses=getSumOfAllExpenses();
        allExpenses.appendText(sumOfExpenses+" €");
    }

    //Adds data to the barchart and opens a new window
    public void showBarChart(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Expense BarChart");
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        yAxis.setLabel("Cost €");
        xAxis.setLabel("Categories");
        double food = 0;
        double entertainment = 0;
        double shopping = 0;
        double living = 0;
        double car = 0;
        double clothes = 0;
        double other = 0;
        //Calculates total sums for each given category
        for(Expense exp: expenses){
            if (Objects.equals(exp.getCategory(), "Food")) {
                food = food+ exp.getCost();
            }
            else if(Objects.equals(exp.getCategory(), "Entertainment")){
                entertainment =entertainment + exp.getCost();
            }
            else if(Objects.equals(exp.getCategory(), "Shopping")){
                shopping += exp.getCost();
            }
            else if(Objects.equals(exp.getCategory(), "Living")){
                living += exp.getCost();
            }
            else if(Objects.equals(exp.getCategory(), "Car")){
                car += exp.getCost();
            }
            else if(Objects.equals(exp.getCategory(), "Clothes")){
                clothes += exp.getCost();
            }
            else if(Objects.equals(exp.getCategory(), "Other")){
                other += exp.getCost();
            }
        }
        series.getData().add(new XYChart.Data<>("Food", food));
        series.getData().add(new XYChart.Data<>("Entertainment", entertainment));
        series.getData().add(new XYChart.Data<>("Shopping", shopping));
        series.getData().add(new XYChart.Data<>("Living", living));
        series.getData().add(new XYChart.Data<>("Car", car));
        series.getData().add(new XYChart.Data<>("Clothes", clothes));
        series.getData().add(new XYChart.Data<>("Other", other));
        //Adds categories and total sums to the bar chart
        barChart.getData().add(series);

        Scene scene = new Scene(barChart,600,500);
        stage.setScene(scene);
        stage.show();
    }
}
