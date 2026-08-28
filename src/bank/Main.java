package bank;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        while (true) {

            Utils.printHeader(
                    "BANK MANAGEMENT SYSTEM"
            );

            System.out.println(
                    "1. Create Account"
            );

            System.out.println(
                    "2. Login"
            );

            System.out.println(
                    "3. Exit"
            );

            int choice =
                    Utils.getInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:

                    bank.createAccount();

                    break;

                case 2:

                    Account account =
                            bank.login();

                    if (account != null) {

                        customerMenu(
                                bank,
                                account
                        );
                    }

                    break;

                case 3:

                    System.out.println(
                            "Thank you for using "
                                    + "our banking system."
                    );

                    System.exit(0);

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }

    private static void customerMenu(
            Bank bank,
            Account account) {

        while (true) {

            Utils.printHeader(
                    "CUSTOMER MENU"
            );

            System.out.println(
                    "Welcome, " +
                            account.getAccountHolderName()
            );

            System.out.println();

            System.out.println(
                    "1. Check Balance"
            );

            System.out.println(
                    "2. Deposit Money"
            );

            System.out.println(
                    "3. Withdraw Money"
            );

            System.out.println(
                    "4. Transfer Money"
            );

            System.out.println(
                    "5. Transaction History"
            );

            System.out.println(
                    "6. Change Password"
            );

            System.out.println(
                    "7. Logout"
            );

            int choice =
                    Utils.getInt(
                            "Enter your choice: "
                    );

            switch (choice) {

                case 1:

                    bank.checkBalance(account);

                    break;

                case 2:

                    bank.deposit(account);

                    break;

                case 3:

                    bank.withdraw(account);

                    break;

                case 4:

                    bank.transfer(account);

                    break;

                case 5:

                    bank.showHistory(account);

                    break;

                case 6:

                    bank.changePassword(account);

                    break;

                case 7:

                    System.out.println(
                            "Logged out successfully."
                    );

                    return;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }
}