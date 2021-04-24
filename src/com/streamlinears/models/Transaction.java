package com.streamlinears.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction{
    public String date;
    public float expense, income;
    // parameterised constructor for Transaction class
    public Transaction(String date, float expense, float income){
        this.date = date;
        this.expense = expense;
        this.income = income;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", expense=" + expense +
                ", income=" + income +
                '}';
    }
}
