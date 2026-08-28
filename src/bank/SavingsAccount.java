package bank;

public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber,
                          String accountHolderName,
                          String password,
                          double balance) {

        super(accountNumber,
                accountHolderName,
                password,
                balance);
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}