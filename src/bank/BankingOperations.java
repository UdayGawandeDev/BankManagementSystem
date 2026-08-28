package bank;

public interface BankingOperations {

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void transfer(String fromAccount,
                  String toAccount,
                  double amount);

    void checkBalance(String accountNumber);

    void showTransactionHistory(String accountNumber);
}