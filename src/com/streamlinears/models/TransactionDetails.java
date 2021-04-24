package com.streamlinears.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TransactionDetails {
    HashMap<String, ArrayList<Transaction>> newTransaction = new HashMap<>();
    ArrayList<Transaction> t;
    float total = 0;
    Scanner sc = new Scanner(System.in);

    // add transactions
    public void add(Transaction transactions){

        // getting date,month,year
        LocalDate localDate = LocalDate.parse(transactions.date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();

        if(newTransaction.containsKey(key)){
            newTransaction.get(key).add(transactions);
            total = 0;
            for(int i=0;i<newTransaction.get(key).size();i++){
                total = total + newTransaction.get(key).get(i).income + newTransaction.get(key).get(i).expense;
            }
        }
        else{
            t = new ArrayList<>();
            t.add(transactions);
            newTransaction.put(key,t);
            total = transactions.expense+transactions.income;
        }
        System.out.println(total);
    }
    public void edit(Transaction transactions){
        LocalDate localDate = LocalDate.parse(transactions.date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();
        if(newTransaction.get(key).contains(transactions)){
            // Entering new details

            System.out.println("Enter new expense");
            float ep = sc.nextFloat();
            System.out.println("Enter new Income");
            float ic = sc.nextFloat();
            System.out.println("Enter new date(dd/MM/yyyy)");
            String date = sc.next();

            Transaction transactions1 = new Transaction(date,ep,ic);
            int x= newTransaction.get(key).indexOf(transactions);
            newTransaction.get(key).set(x,transactions1);

        }
        else{
            System.out.println("Error! This transaction is not present");
        }
    }
    public void delete(Transaction transactions){
        LocalDate localDate = LocalDate.parse(transactions.date, DateTimeFormatter.ISO_DATE);
        String key = localDate.getMonth().toString() + " " + localDate.getYear();
            if(newTransaction.containsKey(key)){
                if(newTransaction.get(key).contains(transactions)){
                    // removing all the transaction
                    newTransaction.get(key).remove(transactions);
                }
                else {
                    System.out.println("The given transaction doesn't exist");
                }
            }
            else {
                System.out.println("The given transaction doesn't exist");
            }

    }
    public void monthDetails(String month, int year){
        String key = month + " " + year;
        System.out.println("\n The detail of entered month is-");
         if(newTransaction.containsKey(key)){
             float totalExpense = 0;
             float totalIncome = 0;
             total=0;
             for(int i=0;i<newTransaction.get(key).size();i++){
                 totalExpense = newTransaction.get(key).get(i).expense;
                 totalIncome = newTransaction.get(key).get(i).income;
                 total = total + newTransaction.get(key).get(i).income + newTransaction.get(key).get(i).expense;
                 System.out.println("Expense - "+ totalExpense+ "Income - "+totalIncome+" Date - "+newTransaction.get(key).get(i).date);
             }
             System.out.println(total);
         }
    }
    //All months details
    public void allMonthDetails(){
        System.out.println("\n");
        for(String key1 : newTransaction.keySet()){
            System.out.println(key1);
            total = 0;
            for(int i=0; i<newTransaction.get(key1).size();i++){
                total = total + newTransaction.get(key1).get(i).income + newTransaction.get(key1).get(i).expense;
            }
        }
        System.out.println(total);
    }


    
    
    
    
    
}
