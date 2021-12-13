package com.example.olioharjoitustyo;
/**
 *Expense Object
 */
import java.io.Serializable;

public class Expense implements Serializable{

    private static final long serialVersionUID = 1L;
    Paivamaara date;
    String category;
    double cost;
    String comment;

    //Expense constructor
    public Expense(Paivamaara date, String category, double cost, String comment) {
        super();
        this.date = date;
        this.category = category;
        this.cost = cost;
        this.comment = comment;
    }

    //Setters and getters
    public Paivamaara getDate() {
        return date;
    }

    public void setDate(Paivamaara date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return date + ", category: " + category + ", cost: " + cost + ", comment: " + comment;
    }
}

