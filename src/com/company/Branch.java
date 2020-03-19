package com.company;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private String branchName;

    public Branch(String branchName) {
        customerList = new ArrayList<>();
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void printCustomers() {
        for(int i=0; i<customerList.size(); i++) {
            System.out.println((i+1) + " Client name: " + customerList.get(i).getName());
        }
    }

    public boolean newTransaction(String name, double amount) {
        int position = customerExists(name);
        if(position >= 0) {
            Customer customer = customerList.get(position);
            customer.addTransaction(amount);
            System.out.println("Transaction successful. Amount: " + amount);
            return true;
        } else {
            System.out.println("Transaction failed. Person with a name " + name + " not found!");
            return false;
        }
    }

    public boolean addClients(String name, double initialAmount) {
        int position = customerExists(name);
        if(position < 0) {
            Customer customer = new Customer(name);
            customerList.add(customer);
            customer.addTransaction(initialAmount);
            System.out.println("Customer with name " + name + " has been added. Initial transaction amount is: " + initialAmount);
            return true;
        } else {
            System.out.println("Customer with a name " + name +" already exists.");
            return false;
        }
    }

    private int customerExists(String name){
        for(int i=0; i<customerList.size(); i++) {
            if(customerList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
