package com.company;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactionList = new ArrayList<Double>();
    private String name;

    public Customer(String name) {
        transactionList = new ArrayList<Double>();
        this.name = name;
    }

    public void addTransaction(double amount) {
        transactionList.add(amount);
        System.out.println("Added " + amount + " to " + this.name + "'s bank account");
    }

    public ArrayList<Double> getTransactionList() {
        return transactionList;
    }

    public String getName() {
        return name;
    }
}
