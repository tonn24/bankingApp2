package com.company;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branchList = new ArrayList<Branch>();
    private String bankName;

    public Bank(String bankName) {
        branchList = new ArrayList<>();
        this.bankName = bankName;
    }

    public void printListOfBranches(){
        for(int i=0; i<branchList.size(); i++) {
            System.out.println((i+1) + ". Branch: " + branchList.get(i).getBranchName());
        }
    }

    public void printListOfCustomers(String branch) {
        int position = branchAlreayExists(branch);
        if(position >= 0) {
            System.out.println("List of customers of branch " + branch);
            branchList.get(position).printCustomers();
        } else {
            System.out.println("Couldn't find branch called " + branch);
        }
    }

    public void transaction(String branchName, String name, double value) {
        int position = branchAlreayExists(branchName);
        if(position >= 0) {
            branchList.get(position).newTransaction(name, value);
        } else {
            System.out.println("Couldn't find branch called " + branchName);
        }
    }

    public void addBranch(String name) {
        int position = branchAlreayExists(name);
        if(position < 0) {
            Branch branch = new Branch(name);
            this.branchList.add(branch);
            System.out.println("branch " + name + " successfully created");
        } else {
            System.out.println("Branch already exists!");
        }
    }

    public void assignCustomer(String branchName, String customerName, double initialAmount) {
        int position = branchAlreayExists(branchName);
        if(position >= 0) {
            this.branchList.get(position).addClients(customerName, initialAmount);
        } else {
            System.out.println("Branch with a name " + branchName + " does not exist");
        }
    }

    private int branchAlreayExists(String name) {
        for(int i=0; i<branchList.size(); i++) {
            if (branchList.get(i).getBranchName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public String getBankName() {
        return bankName;
    }
}
