package org.example;

import lombok.Getter;
import org.example.exceptions.AccountNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    @Getter
    private final List<BankAccount> accounts = new ArrayList<>();

    public boolean createAccount(String accountName, double initialDeposit) {
        BankAccount newAccount = new BankAccount(accountName, initialDeposit);
        newAccount.setAccountNumber(accounts.size() + 1);
        return accounts.add(newAccount);
    }

    public BankAccount findAccount(int accountNumber) {
        try {
            for (BankAccount a: accounts) {
                if(a.getAccountNumber() == accountNumber) {
                    return a;
                }
            }
            throw new AccountNotFoundException("There is no such account!");
        }
        catch(AccountNotFoundException e) {
            throw new AccountNotFoundException(e.getMessage());
        }
    }

    public double transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount receiver = findAccount(toAccountNumber);
        BankAccount sender = findAccount(fromAccountNumber);

        sender.withdraw(amount);
        receiver.deposit(amount);

        return amount;
    }
}
