package org.example;

import org.example.exceptions.AccountNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        bank.createAccount("testName1", 1000);
        bank.createAccount("testName2", 2000);
    }

    @Test
    public void testCreateAccount() {
        assertTrue(bank.createAccount("testName3", 1500));
    }

    @Test
    public void testFindAccountExisting() {
        BankAccount account = bank.findAccount(1);
        assertNotNull(account);
        assertEquals("testName1", account.getAccountName());
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    public void testFindAccountNonExisting() {
        Exception exception = assertThrows(AccountNotFoundException.class, () -> bank.findAccount(3));
        assertTrue(exception.getMessage().contains("There is no such account!"));
    }

    @Test
    public void testTransferMoneySuccess() {
        double transferredAmount = bank.transferMoney(1, 2, 500);
        assertEquals(500, transferredAmount);

        BankAccount sender = bank.findAccount(1);
        BankAccount receiver = bank.findAccount(2);
        assertEquals(500, sender.getBalance());
        assertEquals(2500, receiver.getBalance());
    }

    @Test
    public void testTransferMoneyAccountNotFound() {
        Exception exception = assertThrows(AccountNotFoundException.class,
                () -> bank.transferMoney(1, 3, 500));
        assertTrue(exception.getMessage().contains("There is no such account!"));
    }

    @Test
    public void testTransferMoneyInsufficientFunds() {
        Exception exception = assertThrows(RuntimeException.class,
                () -> bank.transferMoney(1, 2, 3000));
        assertTrue(exception.getMessage().contains("Insufficient funds!"));
    }
}