package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Optional;

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

    private Customer addCustomer(Scanner inputReader){
        System.out.println("Enter the Customer's name: ");
        var customerName = inputReader.nextLine();
        System.out.print("Enter Customer's Tax ID: ");
        var newTaxID = inputReader.nextInt();
        for(var cust: clients){
            if(cust.getCustomerID() == newTaxID)
                return cust;
        }
        var newCust = new Customer(customerName, newTaxID);
        clients.add(newCust);
        return newCust;
    }

    private Optional<Customer> removeCustomer(Scanner inputReader){
        System.out.println("Enter quitter's Tax ID: ");
        var taxID = inputReader.nextInt();
        for(var cust: clients){
            if(cust.getCustomerID() == taxID){
                clients.remove(cust);
                return Optional.of(cust);
            }
        }
        return Optional.empty();
    }

    public void doBanking(){
        var reader = new Scanner(System.in);
        while(true){
            printMenu();
            var userSelection = reader.nextInt();
            //eat trailing newline
            reader.nextLine();
            switch(userSelection){

                case 1: //add customer
                    var customer = addCustomer(reader);
                    System.out.println("added customer " + customer.getName());
                    break;

                case 3: //remove customer
                    var oldCustomer = removeCustomer(reader);
                    var message = "";
                    if(oldCustomer.isPresent())
                        message = oldCustomer.get().getName() + " is no longer with this bank";
                    else
                        message = "is already not a customer of this bank";
                    System.out.println("Customer " + message);
                    break;

                case 5: //end program
                    System.exit(0);

                default:
                    System.out.println("Wait, what..? \n" + "Okay, let's try again. \n");
            }
        }
    }
}
