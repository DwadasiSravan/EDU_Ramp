package Bank;

public class Customer {
    private String name;
    private int id;
    private String number;
    private String branch;
    private String email;
    private String gender;
    private double accountBalance;
    private String accountNumber;

    public Customer(String name, int id, String number, String branch, String email, String gender, double accountBalance, String accountNumber) {
        this.name = name;
        this.id = id;
        this.number = number;
        this.branch = branch;
        this.email = email;
        this.gender = gender;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getBranch() {
        return branch;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}