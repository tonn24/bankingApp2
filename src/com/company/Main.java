package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static Scanner s = new Scanner(System.in);
    private static Bank bank = new Bank("LHV");

    public static void printInstructions(){
        System.out.print("Choose your option: \n"
                + "\t 1) Create new branch \n"
                + "\t 2) Add customer to that branch with initial transaction \n"
                + "\t 3) Make a transaction for an existing customer for that branch \n"
                + "\t 4) List of branches \n"
                + "\t 5) List of customers \n"
                + "\t 6) Show the menu \n"
                + "\t 7) Quit \n");
    }

    public static void main(String[] args) {

        boolean quit = false;
        printInstructions();
        System.out.println("Enter your choice: ");
        while(!quit) {
            int choice = s.nextInt();
            s.nextLine();
            switch(choice) {
                case 1:
                    createBranch();
                    System.out.println("\nEnter your choice: ");
                    break;
                case 2:
                    addCustomer();
                    System.out.println("\nEnter your choice: ");
                    break;
                case 3:
                    makeTransaction();
                    System.out.println("\nEnter your choice: ");
                    break;
                case 4:
                    bank.printListOfBranches();
                    System.out.println("\nEnter your choice: ");
                    break;
                case 5:
                    System.out.println("Enter branch name where you want print the customers: ");
                    String branch = s.nextLine();
                    bank.printListOfCustomers(branch);
                    System.out.println("\nEnter your choice: ");
                    break;
                case 6:
                    printInstructions();
                    System.out.println("\nEnter your choice: ");
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void createBranch() {
        System.out.println("Enter branch name: ");
        String branchName = s.nextLine();
        bank.addBranch(branchName);
    }

    public static void addCustomer() {
        System.out.println("Please enter branch where to add customer: ");
        String branch = s.nextLine();
        System.out.println("Please enter customer name: ");
        String name = s.nextLine();
        System.out.println("Please enter customer initial value: ");
        double value = s.nextDouble();
        bank.assignCustomer(branch, name, value);
    }

    public static void makeTransaction(){
        System.out.println("Enter existing branch name: ");
        String branchName = s.next();
        System.out.println("Please customer name: ");
        String name = s.nextLine();
        System.out.println("Please enter transaction value: ");
        double value = s.nextDouble();
        bank.transaction(branchName, name, value);
    }

}
