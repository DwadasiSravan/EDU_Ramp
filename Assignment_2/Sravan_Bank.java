package Assignment_2;
import java.util.Scanner;
import java.util.Random;

interface BankAccount {
    boolean openAccount();
    void displayAccountDetails();
    double calculateInterest();
    void withdraw(double amount);
    String getAccountNumber();
    String getAccountHolderName();
    String getMobileNumber();
    double getBalance();
    boolean isActive();
}

class SavingAccount implements BankAccount {
    private static final String ACCOUNT_PREFIX = "SRAV";
    private String accountNumber;
    private String accountHolderName;
    private String mobileNumber;
    private double balance;
    private boolean isActive;
    private static final double MIN_DEPOSIT = 1000;
    private static final double INTEREST_RATE = 0.04;
    private static final int MAX_WITHDRAWALS = 3;
    private int withdrawalsThisMonth = 0;

    public SavingAccount(String accountHolderName, String mobileNumber, double initialDeposit) {
        this.accountNumber = ACCOUNT_PREFIX + generateRandomAccountNumber();
        this.accountHolderName = accountHolderName;
        this.mobileNumber = mobileNumber;
        this.balance = initialDeposit;
        this.isActive = false;
    }

    private String generateRandomAccountNumber() {
        Random rand = new Random();
        long number = 100_000_000L + (long)(rand.nextDouble() * 900_000_000L);
        return String.valueOf(number);
    }

    @Override
    public boolean openAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Are you an individual customer? (yes/no): ");
        String type = sc.nextLine();
        if (!type.equalsIgnoreCase("yes")) {
            System.out.println("Only individuals can open a savings account.");
            return false;
        }
        if (balance < MIN_DEPOSIT) {
            System.out.println("Minimum deposit for Savings Account is ₹" + MIN_DEPOSIT);
            return false;
        }
        System.out.print("All details are valid. Do you want to activate this account? (yes/no): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            isActive = true;
            System.out.println("Savings Account opened and activated successfully!");
            return true;
        } else {
            System.out.println("Account activation cancelled.");
            return false;
        }
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void withdraw(double amount) {
        Scanner sc = new Scanner(System.in);
        if (!isActive) {
            System.out.println("Account is not active.");
            return;
        }
        if (withdrawalsThisMonth >= MAX_WITHDRAWALS) {
            System.out.println("Withdrawal limit reached for this month.");
            return;
        }
        while (amount > balance) {
            System.out.println("Insufficient balance.");
            System.out.print("Do you want to re-enter the withdrawal amount? (yes/no): ");
            String choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                return;
            }
            System.out.print("Enter withdrawal amount: ");
            amount = Double.parseDouble(sc.nextLine());
        }
        balance -= amount;
        withdrawalsThisMonth++;
        System.out.println("Withdrawal successful. Remaining balance: ₹" + balance);
        if (balance < MIN_DEPOSIT) {
            System.out.println("Warning: Your balance is below the minimum required (₹" + MIN_DEPOSIT + "). Please deposit more to avoid account restrictions.");
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println("Account Status: " + (isActive ? "Active" : "Inactive"));
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }
}

class CurrentAccount implements BankAccount {
    private static final String ACCOUNT_PREFIX = "SRAV";
    private String accountNumber;
    private String accountHolderName;
    private String mobileNumber;
    private double balance;
    private boolean isActive;
    private String customerType;
    private static final double MIN_DEPOSIT = 1000;
    private static final double MIN_BALANCE = 2000;
    private static final double PENALTY = 500;

    public CurrentAccount(String accountHolderName, String mobileNumber, double initialDeposit, String customerType) {
        this.accountNumber = ACCOUNT_PREFIX + generateRandomAccountNumber();
        this.accountHolderName = accountHolderName;
        this.mobileNumber = mobileNumber;
        this.balance = initialDeposit;
        this.customerType = customerType;
        this.isActive = false;
    }

    private String generateRandomAccountNumber() {
        Random rand = new Random();
        long number = 100_000_000L + (long)(rand.nextDouble() * 900_000_000L);
        return String.valueOf(number);
    }

    @Override
    public boolean openAccount() {
        Scanner sc = new Scanner(System.in);
        if (balance < MIN_DEPOSIT) {
            System.out.println("Minimum deposit for Current Account is ₹" + MIN_DEPOSIT);
            return false;
        }
        if (!customerType.equalsIgnoreCase("individual") && !customerType.equalsIgnoreCase("business")) {
            System.out.println("Current account can be opened by individuals or businesses only.");
            return false;
        }
        System.out.print("All details are valid. Do you want to activate this account? (yes/no): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            isActive = true;
            System.out.println("Current Account opened and activated successfully!");
            return true;
        } else {
            System.out.println("Account activation cancelled.");
            return false;
        }
    }

    @Override
    public double calculateInterest() {
        return 0.0;
    }

    @Override
    public void withdraw(double amount) {
        Scanner sc = new Scanner(System.in);
        if (!isActive) {
            System.out.println("Account is not active.");
            return;
        }
        while (amount > balance) {
            System.out.println("Insufficient balance.");
            System.out.print("Do you want to re-enter the withdrawal amount? (yes/no): ");
            String choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                return;
            }
            System.out.print("Enter withdrawal amount: ");
            amount = Double.parseDouble(sc.nextLine());
        }
        double tempBalance = balance - amount;
        if (tempBalance < MIN_BALANCE) {
            System.out.println("Warning: Your balance after withdrawal will be below the minimum required (₹" + MIN_BALANCE + ").");
            System.out.print("Do you want to deposit more to avoid the penalty of ₹" + PENALTY + "? (yes/no): ");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                System.out.print("Enter amount to deposit: ");
                double addAmount = Double.parseDouble(sc.nextLine());
                tempBalance += addAmount;
                balance += addAmount;
                if (tempBalance < MIN_BALANCE) {
                    System.out.println("Still below minimum balance. Penalty will be charged.");
                    balance -= amount;
                    balance -= PENALTY;
                    System.out.println("Withdrawal successful. Penalty of ₹" + PENALTY + " charged. Remaining balance: ₹" + balance);
                } else {
                    balance -= amount;
                    System.out.println("Withdrawal successful. Remaining balance: ₹" + balance);
                }
            } else {
                balance -= amount;
                balance -= PENALTY;
                System.out.println("Withdrawal successful. Penalty of ₹" + PENALTY + " charged. Remaining balance: ₹" + balance);
            }
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: ₹" + balance);
        }
        if (balance < MIN_BALANCE) {
            System.out.println("Warning: Your balance is below the minimum required (₹" + MIN_BALANCE + "). Penalty of ₹" + PENALTY + " may be charged.");
        }
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Balance: ₹" + balance);
        System.out.println("Account Status: " + (isActive ? "Active" : "Inactive"));
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }
}

public class Sravan_Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Sravan Dwadasi Bank!!!");
        System.out.print("Enter Account Type (Saving/Current): ");
        String type = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double deposit = Double.parseDouble(sc.nextLine());

        BankAccount account = null;

        if (type.equalsIgnoreCase("Saving")) {
            account = new SavingAccount(name, mobile, deposit);
        } else if (type.equalsIgnoreCase("Current")) {
            System.out.print("Are you an Individual or Business? ");
            String custType = sc.nextLine();
            account = new CurrentAccount(name, mobile, deposit, custType);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        if (account.openAccount()) {
            account.displayAccountDetails();

            if (account instanceof SavingAccount) {
                double interest = account.calculateInterest();
                System.out.println("Yearly Interest: ₹" + interest);
            }

            System.out.print("Do you want to withdraw? (yes/no): ");
            String withdrawChoice = sc.nextLine();
            if (withdrawChoice.equalsIgnoreCase("yes")) {
                System.out.print("Enter withdrawal amount: ");
                double amount = Double.parseDouble(sc.nextLine());
                account.withdraw(amount);
                account.displayAccountDetails();
            }
        }
    }
}