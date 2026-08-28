package bank;

public class Customer {

    private String customerId;
    private String name;
    private String email;
    private String mobile;

    public Customer(String customerId,
                    String name,
                    String email,
                    String mobile) {

        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public void displayCustomer() {

        System.out.println("-------------------------");
        System.out.println("Customer ID : " + customerId);
        System.out.println("Name        : " + name);
        System.out.println("Email       : " + email);
        System.out.println("Mobile      : " + mobile);
        System.out.println("-------------------------");
    }
}