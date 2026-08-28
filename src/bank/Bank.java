package bank;


import bank.exception.InvalidAccountException;
import bank.exception.InvalidAmountException;
import bank.exception.InsufficientBalanceException;
import java.util.HashMap;
import java.util.Map;


public class Bank {

    private Map<String, Account> accounts;

    public Bank() {

        accounts =
                FileManager.loadAccounts();

        FileManager.loadTransactions(accounts);
    }
    // CREATE ACCOUNT
    public void createAccount() {

        Utils.printHeader("CREATE ACCOUNT");

        String name =
                Utils.getString(
                        "Enter Name: "
                );

        String password =
                Utils.getString(
                        "Create Password: "
                );

        String type =
                Utils.getString(
                        "Account Type (Savings/Current): "
                );

        double initialDeposit =
                Utils.getDouble(
                        "Initial Deposit: ₹"
                );

try {

    if (initialDeposit < 0) {

        throw new InvalidAmountException(
                "Initial deposit cannot be negative."
        );
    }

} catch (InvalidAmountException e) {

    System.out.println(
            "Error: " + e.getMessage()
    );

    return;
}

        String accountNumber =
                generateAccountNumber();

        Account account;

        if (type.equalsIgnoreCase("Savings")) {

            account =
                    new SavingsAccount(
                            accountNumber,
                            name,
                            password,
                            initialDeposit
                    );

        } else if (
                type.equalsIgnoreCase("Current")) {

            account =
                    new CurrentAccount(
                            accountNumber,
                            name,
                            password,
                            initialDeposit
                    );

        } else {

            System.out.println(
                    "Invalid account type."
            );

            return;
        }

        accounts.put(
                accountNumber,
                account
        );
        FileManager.saveAccounts(accounts);

        System.out.println();
        System.out.println(
                "Account created successfully!"
        );

        System.out.println(
                "Your Account Number: " +
                        accountNumber
        );
    }

    // GENERATE ACCOUNT NUMBER
    private String generateAccountNumber() {

        return "AC" +
                (100000 +
                        accounts.size() + 1);
    }

    // LOGIN
    public Account login() {

        Utils.printHeader("LOGIN");

        String accountNumber =
                Utils.getString(
                        "Account Number: "
                );

        String password =
                Utils.getString(
                        "Password: "
                );

        Account account =
                accounts.get(accountNumber);

        if (account == null) {

            System.out.println(
                    "Account not found."
            );

            return null;
        }

        if (!account.getPassword()
                .equals(password)) {

            System.out.println(
                    "Incorrect password."
            );

            return null;
        }

        System.out.println(
                "Login successful!"
        );

        return account;
    }

    // DEPOSIT
public void deposit(Account account) {

    double amount =
            Utils.getDouble(
                    "Enter amount to deposit: ₹"
            );

    try {

        account.deposit(amount);

        Transaction transaction =
                account.getTransactions()
                        .get(
                                account.getTransactions()
                                        .size() - 1
                        );

        FileManager.saveTransaction(
                account.getAccountNumber(),
                transaction
        );

        FileManager.saveAccounts(accounts);

    } catch (InvalidAmountException e) {

        System.out.println(
                "Error: " + e.getMessage()
        );
    }
}
    // WITHDRAW
 public void withdraw(Account account) {

    double amount =
            Utils.getDouble(
                    "Enter amount to withdraw: ₹"
            );

    try {

        account.withdraw(amount);

        Transaction transaction =
                account.getTransactions()
                        .get(
                                account.getTransactions()
                                        .size() - 1
                        );

        FileManager.saveTransaction(
                account.getAccountNumber(),
                transaction
        );

        FileManager.saveAccounts(accounts);

    } catch (InvalidAmountException |
             InsufficientBalanceException e) {

        System.out.println(
                "Error: " + e.getMessage()
        );
    }
}
    // TRANSFER
public void transfer(Account sender) {

    String receiverNumber =
            Utils.getString(
                    "Receiver Account Number: "
            );

    Account receiver =
            accounts.get(receiverNumber);

    try {

        if (receiver == null) {

            throw new InvalidAccountException(
                    "Receiver account not found."
            );
        }

        if (sender.getAccountNumber()
                .equals(receiverNumber)) {

            throw new InvalidAccountException(
                    "You cannot transfer money "
                    + "to your own account."
            );
        }

        double amount =
                Utils.getDouble(
                        "Enter transfer amount: ₹"
                );

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Transfer amount must be greater than zero."
            );
        }

        if (amount > sender.getBalance()) {

            throw new InsufficientBalanceException(
                    "Insufficient balance."
            );
        }


        int senderSize =
                sender.getTransactions().size();

        int receiverSize =
                receiver.getTransactions().size();


        sender.withdraw(amount);

        receiver.deposit(amount);


        Transaction senderTransaction =
                sender.getTransactions()
                        .get(senderSize);


        Transaction receiverTransaction =
                receiver.getTransactions()
                        .get(receiverSize);


        FileManager.saveTransaction(
                sender.getAccountNumber(),
                senderTransaction
        );

        FileManager.saveTransaction(
                receiver.getAccountNumber(),
                receiverTransaction
        );


        FileManager.saveAccounts(accounts);


        System.out.println(
                "Transfer successful!"
        );

    } catch (InvalidAccountException |
             InvalidAmountException |
             InsufficientBalanceException e) {

        System.out.println(
                "Transfer failed: " +
                e.getMessage()
        );
    }
}
    // BALANCE
    public void checkBalance(Account account) {

        account.showBalance();
    }

    // TRANSACTION HISTORY
    public void showHistory(Account account) {

        account.showTransactionHistory();
    }

    // CHANGE PASSWORD
    public void changePassword(Account account) {

        String oldPassword =
                Utils.getString(
                        "Enter old password: "
                );

        if (!account.getPassword()
                .equals(oldPassword)) {

            System.out.println(
                    "Incorrect old password."
            );

            return;
        }

        String newPassword =
                Utils.getString(
                        "Enter new password: "
                );

        account.setPassword(newPassword);

        FileManager.saveAccounts(accounts);

        System.out.println(
                "Password changed successfully."
        );
    }
}