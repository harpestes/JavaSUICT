package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.exceptions.InsufficientFundsException;
import org.example.exceptions.NegativeAmountException;


@Getter
public class BankAccount {
    @Setter
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public double deposit(double amount) {
        try {
            if(amount >= 0) {
                balance += amount;
            }
            else throw new NegativeAmountException("Amount can not be negative!");
        }
        catch(NegativeAmountException e) {
            throw new NegativeAmountException(e.getMessage());
        }
        return amount;
    }
    public double withdraw(double amount) {
        try {
            if(amount < 0) throw new NegativeAmountException("Amount can not be negative!");
            else if(balance < amount) throw new InsufficientFundsException("Insufficient funds!");
            else balance -= amount;
        }
        catch(NegativeAmountException | InsufficientFundsException e) {
            throw new RuntimeException(e.getMessage());
        }
        return amount;
    }

    public String getAccountSummary() {
        return "Account number: " + accountNumber + ", Account name: " + accountName + ", Balance: " + balance + ";\n";
    }
}
