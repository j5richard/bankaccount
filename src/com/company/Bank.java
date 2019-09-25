package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> accounts;
    private ArrayList<Customer> clients;

    public Bank(){
        accounts = new ArrayList<BankAccount>();
        clients = new ArrayList<Customer>();
    }

    private void printMenu(){
        System.out.println ("Please select an option below:");
        System.out.println("  [1] Add a customer");
        System.out.println("  [2] Select a customer for banking");
        System.out.println("  [3] Remove customer");
        System.out.println("  [4] Do yearly maintenance");
        System.out.println("  [5] Exit program");
        System.out.println("  Please type a number: " );
    }

    public void doBanking(){
        var reader = new Scanner(System.in);
        while(true){
            printMenu();
            var userSelection = reader.nextInt();
            switch(userSelection){
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wait, what..?" + "\n" + "Okay, let's try again.");
            }
        }
    }
}
