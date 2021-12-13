package com.example.olioharjoitustyo.controllers;
/**
 *Methods: Save File, Load File, calculate expenses
 */
import com.example.olioharjoitustyo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AddExpensesController implements Initializable {
    //Array List where all expenses added!
    protected static ArrayList<Expense> expenses = new ArrayList<>();
    @FXML
    private TextField expenseComment;
    @FXML
    private TextField expenseCost;
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private ComboBox<String> comboBox;
    //Creates the Dropdown list (ComboBox) categories
    ObservableList<String> expenseList = FXCollections.observableArrayList("Food" ,"Entertainment" ,"Shopping" ,"Living", "Car", "Clothes", "Other");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(expenseList);
    }

    //Adds expenses to the array list
    @FXML
    public void addExpense(ActionEvent actionEvent) throws IOException {
        try {
            //Get data from date picker calendar and modify the date to String
            LocalDate expenseDate = myDatePicker.getValue();
            String formattedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(expenseDate);
            Paivamaara day = new Paivamaara(formattedDate);
            //Get the category from comboBox
            String expense= comboBox.getValue();
            //Get the cost
            double cost = Double.parseDouble(expenseCost.getText());
            //Get the comment
            String comment = expenseComment.getText();
            //Create an Expense object
            Expense a = new Expense(day,expense,cost,comment);
            expenses.add(a);
            //Show alert box: Expense successfully added
            AlertBox.displaySuccessfulAdd();
            //Clear comment and cost data
            expenseComment.clear();
            expenseCost.clear();
        } catch(Exception e){
            //If error happens show error box and do not add expense
            AlertBox.displayError();
        }
    }

    //Total expenses during specific date
    //Uses onSama method from Paivamaara class
    public static String getSumOfExpensesDay(Paivamaara day) {
        double sum = 0;
        for (Expense x: expenses) {
            if(x.getDate().onSama(day)) {
                sum+=x.getCost();
            }
        }
        //Show only 2 decimals
        String str = String.format("%.2f",sum);
        return str;
    }

    //Get expenses from specific date and print them using String Builder
    public static StringBuilder getExpensesDay(Paivamaara day) {
        StringBuilder expen = new StringBuilder();
        for (Expense x: expenses) {
            if(x.getDate().onSama(day)) {
                expen.append(x.getDate()+"\t\t"+x.getCategory()+"\t\t\t"+x.getCost()+" €\t\t\t"+x.getComment()+"\n");
            }
        }
        return expen;
    }
    //Calculates total expenses
    public static String getSumOfAllExpenses() {
        double sum = 0;
        for (Expense x: expenses) {
                sum+=x.getCost();
        }
        //Show only 2 decimals
        String str = String.format("%.2f",sum);
        return str;
    }

    //Save the objects to the file
    //The path to the file is already given but this could be modified
    public static void writeToFile() {
        String file ="/Users/jerekorhonen/OlioOhjelmointiHarjoitusTyo/Expenses";
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file))){
            write.writeObject(expenses);
        }
        catch(Exception ex) {
            System.out.println("Problems with " + file);
            ex.printStackTrace();
        }
    }

    //Program must start form reading the file because then it reads the file and saves the Expense objects
    //to the ArrayList->
    //Reads saved objects from the file
    //Uses object serilization
    @SuppressWarnings("unchecked")
    public static void readFromFile() {
        //The file path set automatically because the same file must open everytime
        //Empty the expenses list -> no double adding
        expenses.clear();
        String file ="/Users/jerekorhonen/OlioOhjelmointiHarjoitusTyo/Expenses";
        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(file))){
            //Create a new temporary array list
            ArrayList<Expense> tmp = (ArrayList<Expense>) read.readObject();
            //Add objects from tmp list to the real ArrayList
            expenses.addAll(tmp);
            read.close();
        }
        catch(Exception e) {
            System.out.println("Problems with " + file);
            e.printStackTrace();
        }
    }
}