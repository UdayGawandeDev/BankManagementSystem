package bank;

public class CurrentAccount extends Account {

    public CurrentAccount(String accountNumber,
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
        return "Current";
    }
}