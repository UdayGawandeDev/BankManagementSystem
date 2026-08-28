package bank;

import bank.exception.InvalidAmountException;
import bank.exception.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private String accountNumber;
    private String accountHolderName;
    private String password;
    private double balance;

    private List<Transaction> transactions;


    public Account(
            String accountNumber,
            String accountHolderName,
            String password,
            double balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.password = password;
        this.balance = balance;

        transactions = new ArrayList<>();
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }


    public String getPassword() {
        return password;
    }


    public double getBalance() {
        return balance;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    // ==========================================
    // DEPOSIT
    // ==========================================

    public void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Deposit amount must be greater than zero."
            );
        }

        balance += amount;

        Transaction transaction =
                new Transaction(
                        Utils.getTransactionId(),
                        TransactionType.DEPOSIT,
                        amount,
                        balance,
                        "Cash Deposit"
                );

        transactions.add(transaction);

        System.out.println(
                "₹" + amount +
                " deposited successfully."
        );
    }


    // ==========================================
    // WITHDRAW
    // ==========================================

    public void withdraw(double amount)
            throws InvalidAmountException,
            InsufficientBalanceException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Withdrawal amount must be greater than zero."
            );
        }

        if (amount > balance) {

            throw new InsufficientBalanceException(
                    "Insufficient balance."
            );
        }

        balance -= amount;

        Transaction transaction =
                new Transaction(
                        Utils.getTransactionId(),
                        TransactionType.WITHDRAW,
                        amount,
                        balance,
                        "Cash Withdrawal"
                );

        transactions.add(transaction);

        System.out.println(
                "₹" + amount +
                " withdrawn successfully."
        );
    }


    // ==========================================
    // TRANSFER TRANSACTION
    // ==========================================

    public void addTransferTransaction(
            double amount,
            String description) {

        Transaction transaction =
                new Transaction(
                        Utils.getTransactionId(),
                        TransactionType.TRANSFER,
                        amount,
                        balance,
                        description
                );

        transactions.add(transaction);
    }


    // ==========================================
    // BALANCE
    // ==========================================

    public void showBalance() {

        Utils.printHeader(
                "ACCOUNT DETAILS"
        );

        System.out.println(
                "Account Number : " +
                accountNumber
        );

        System.out.println(
                "Account Holder : " +
                accountHolderName
        );

        System.out.println(
                "Account Type   : " +
                getAccountType()
        );

        System.out.println(
                "Balance        : ₹" +
                balance
        );
    }


    // ==========================================
    // TRANSACTION HISTORY
    // ==========================================

    public void showTransactionHistory() {

        Utils.printHeader(
                "TRANSACTION HISTORY"
        );

        if (transactions.isEmpty()) {

            System.out.println(
                    "No transactions found."
            );

            return;
        }

        for (Transaction transaction :
                transactions) {

            transaction.displayTransaction();
        }
    }


    public abstract String getAccountType();
}