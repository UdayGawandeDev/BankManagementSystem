package bank;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class FileManager {

    private static final String ACCOUNT_FILE =
            "data/accounts.txt";

    private static final String TRANSACTION_FILE =
            "data/transactions.txt";


    // ==========================================
    // SAVE ACCOUNTS
    // ==========================================

    public static void saveAccounts(
            Map<String, Account> accounts) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(ACCOUNT_FILE))) {

            for (Account account : accounts.values()) {

                writer.write(
                        account.getAccountNumber()
                                + "|" +
                                account.getAccountHolderName()
                                + "|" +
                                account.getPassword()
                                + "|" +
                                account.getBalance()
                                + "|" +
                                account.getAccountType()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving account data."
            );
        }
    }


    // ==========================================
    // LOAD ACCOUNTS
    // ==========================================

    public static Map<String, Account>
    loadAccounts() {

        Map<String, Account> accounts =
                new HashMap<>();

        File file =
                new File(ACCOUNT_FILE);

        if (!file.exists()) {
            return accounts;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(ACCOUNT_FILE))) {

            String line;

            while ((line = reader.readLine())
                    != null) {

                String[] data =
                        line.split("\\|");

                if (data.length != 5) {
                    continue;
                }

                String accountNumber =
                        data[0];

                String name =
                        data[1];

                String password =
                        data[2];

                double balance =
                        Double.parseDouble(data[3]);

                String accountType =
                        data[4];

                Account account;

                if (accountType.equalsIgnoreCase(
                        "Savings")) {

                    account =
                            new SavingsAccount(
                                    accountNumber,
                                    name,
                                    password,
                                    balance
                            );

                } else {

                    account =
                            new CurrentAccount(
                                    accountNumber,
                                    name,
                                    password,
                                    balance
                            );
                }

                accounts.put(
                        accountNumber,
                        account
                );
            }

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error loading account data."
            );
        }

        return accounts;
    }


    // ==========================================
    // SAVE TRANSACTION
    // ==========================================

    public static void saveTransaction(
            String accountNumber,
            Transaction transaction) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(
                                     TRANSACTION_FILE,
                                     true))) {

            writer.write(
                    accountNumber
                            + "|" +
                            transaction.getTransactionId()
                            + "|" +
                            transaction.getType()
                            + "|" +
                            transaction.getAmount()
                            + "|" +
                            transaction.getDate()
                            + "|" +
                            transaction
                                    .getBalanceAfterTransaction()
                            + "|" +
                            transaction.getDescription()
            );

            writer.newLine();

        } catch (IOException e) {

            System.out.println(
                    "Error saving transaction."
            );
        }
    }


    // ==========================================
    // LOAD TRANSACTIONS
    // ==========================================

    public static void loadTransactions(
            Map<String, Account> accounts) {

        File file =
                new File(TRANSACTION_FILE);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     TRANSACTION_FILE))) {

            String line;

            while ((line = reader.readLine())
                    != null) {

                String[] data =
                        line.split("\\|", 7);

                if (data.length != 7) {
                    continue;
                }

                String accountNumber =
                        data[0];

                Account account =
                        accounts.get(accountNumber);

                if (account == null) {
                    continue;
                }

                TransactionType type =
                        TransactionType.valueOf(
                                data[2]
                        );

                double amount =
                        Double.parseDouble(data[3]);

                double balance =
                        Double.parseDouble(data[5]);

                LocalDateTime date =
                        LocalDateTime.parse(data[4]);

                Transaction transaction =
                        new Transaction(
                                data[1],
                                type,
                                amount,
                                date,
                                balance,
                                data[6]
                        );
                account.getTransactions()
                        .add(transaction);
            }

        } catch (IOException |
                 IllegalArgumentException e) {

            System.out.println(
                    "Error loading transactions."
            );
        }
    }
}