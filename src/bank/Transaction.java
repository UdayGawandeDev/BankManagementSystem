package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String transactionId;

    private TransactionType type;

    private double amount;

    private LocalDateTime date;

    private double balanceAfterTransaction;

    private String description;


    // Normal transaction constructor
    public Transaction(
            String transactionId,
            TransactionType type,
            double amount,
            double balanceAfterTransaction,
            String description) {

        this.transactionId =
                transactionId;

        this.type = type;

        this.amount =
                amount;

        this.balanceAfterTransaction =
                balanceAfterTransaction;

        this.description =
                description;

        this.date =
                LocalDateTime.now();
    }


    // Constructor used when loading
    // transaction from file
    public Transaction(
            String transactionId,
            TransactionType type,
            double amount,
            LocalDateTime date,
            double balanceAfterTransaction,
            String description) {

        this.transactionId =
                transactionId;

        this.type =
                type;

        this.amount =
                amount;

        this.date =
                date;

        this.balanceAfterTransaction =
                balanceAfterTransaction;

        this.description =
                description;
    }


    public String getTransactionId() {
        return transactionId;
    }


    public TransactionType getType() {
        return type;
    }


    public double getAmount() {
        return amount;
    }


    public LocalDateTime getDate() {
        return date;
    }


    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }


    public String getDescription() {
        return description;
    }


    public void displayTransaction() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy HH:mm:ss"
                );

        System.out.println(
                "----------------------------------------"
        );

        System.out.println(
                "Transaction ID : " +
                        transactionId
        );

        System.out.println(
                "Type           : " +
                        type
        );

        System.out.println(
                "Amount         : ₹" +
                        amount
        );

        System.out.println(
                "Description    : " +
                        description
        );

        System.out.println(
                "Date           : " +
                        date.format(formatter)
        );

        System.out.println(
                "Balance        : ₹" +
                        balanceAfterTransaction
        );
    }
}