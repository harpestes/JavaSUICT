# Лабораторна робота №5

## Функціональність програми

**Реалізована надійна та стійка до помилок програма, яка імітує спрощену
банківську систему. Ця система включає створення рахунків, фінансові операції та функції зведення рахунків. Програма
може елегантно обробляти різні типи помилок, не ламаючись. Реалізовані спеціалізовані класи винятків для обробки
спеціалізованих сценаріїв помилок.**

## Опис роботи

1. Створив клас [BankAccount], додав поля `accountNumber`, `accountName` і `balance`, додав конструктор і анотації `@Getter` та `@Setter`.
2. Реалізував методи  `deposit(double amount)`, `withdraw(double amount)` та `getAccountSummary()`
3. Створити спеціалізовані класи винятків:
   - [AccountNotFoundException]
   - [InsufficientFundsException]
   - [NegativeAmountException]
4. Створив клас [Bank], в якому створив колекцію акаунтів [BankAccount]
5. У цьому ж класі, реалізував методи `createAccount(String accountName, double initialDeposit)`, `findAccount(int accountNumber)` та `transferMoney(int fromAccountNumber, int toAccountNumber, double amount)`
6. В методах, де це необхідно, додав обробку спеціалізованих винятків.
7. Створив тести [BankAccountTest] та [BankTest].

## Висновок

**Під час лабораторної роботи я навчився оброблювати винятки у Java**

[BankAccount]: BankAccount.java
[Bank]: Bank.java
[AccountNotFoundException]: exceptions/AccountNotFoundException.java
[InsufficientFundsException]: exceptions/InsufficientFundsException.java
[NegativeAmountException]: exceptions/NegativeAmountException.java
[BankTest]: ../../../../test/java/org/example/BankTest.java
[BankAccountTest]: ../../../../test/java/org/example/BankAccountTest.java