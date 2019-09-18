package com.company;

public class BankAccount {
    private double balance;
    private float interestRate;
    private int accountID;
    private static int nextID = 1000;

    public BankAccount() {
        interestRate = 0.02f;
        accountID = nextID;
        nextID++;
    }

    public BankAccount(double initialBalance, float initialRate){
        balance = initialBalance;
        interestRate = initialRate;
        accountID = nextID;
        nextID++;
    }

    public void deposit(double amount){
        balance+=amount;
    }

    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
                    return true;
        }return false;
    }

    public int GetaccountID(){
        return accountID;
    }

    public double checkBalance(){
        return balance;
    }

    public double addInterest(){
        balance = interestRate*balance + balance;
        return balance;
    }

}
