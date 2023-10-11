package org.example;

import org.example.exceptions.NegativeAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount("testName", 1000);
    }

    @Test
    public void testDepositValidAmount() {
        double depositedAmount = bankAccount.deposit(500.0);
        assertEquals(1500, bankAccount.getBalance());
        assertEquals(500, depositedAmount);
    }

    @Test
    public void testDepositNegativeAmount() {
        Exception exception = assertThrows(NegativeAmountException.class, () -> bankAccount.deposit(-500));
        assertTrue(exception.getMessage().contains("Amount can not be negative!"));
        assertEquals(1000, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawValidAmount() {
        double withdrawnAmount = bankAccount.withdraw(500.0);
        assertEquals(500, bankAccount.getBalance());
        assertEquals(500, withdrawnAmount);
    }

    @Test
    public void testWithdrawNegativeAmount() {
        Exception exception = assertThrows(RuntimeException.class, () -> bankAccount.withdraw(-500));
        assertTrue(exception.getMessage().contains("Amount can not be negative!"));
        assertEquals(1000, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        Exception exception = assertThrows(RuntimeException.class, () -> bankAccount.withdraw(1500));
        assertTrue(exception.getMessage().contains("Insufficient funds!"));
        assertEquals(1000, bankAccount.getBalance());
    }
}