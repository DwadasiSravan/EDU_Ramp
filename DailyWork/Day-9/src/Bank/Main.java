package Bank;

import java.util.*;

public class Main {
    private static Bank bank = new Bank();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to the IVL Banking System!!!!!");

        // Create some random branches and customers
        setupDemoData();

        System.out.println("\nPlease select an option:");
        System.out.println("1. Create an account for customer");
        System.out.println("2. Create a new Branch");
        System.out.println("3. Find the customer");
        System.out.println("4. Get the customers list in a particular branch");
        System.out.print("Enter your choice (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                createCustomer();
                break;
            case 2:
                createBranch();
                break;
            case 3:
                findCustomer();
                break;
            case 4:
                getCustomersInBranch();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        System.out.println("\nThank you for using IVL Banking System. Goodbye!");
    }

    private static void setupDemoData() {
        Branch b1 = new Branch("Ameerpet", "Ravi", "0401234567", "IVL0001", "500016");
        Branch b2 = new Branch("Madhapur", "Sita", "0407654321", "IVL0002", "500081");
        Branch b3 = new Branch("Kukatpally", "Manoj", "0401111222", "IVL0003", "500072");

        bank.addBranch(b1);
        bank.addBranch(b2);
        bank.addBranch(b3);

        b1.addCustomer(new Customer("Kranthi", 1, "9000000001", b1.getBranchName(), "kranthi@email.com", "Male", 10000.0, generateAccountNumber(b1.getBranchName())));
        b1.addCustomer(new Customer("Anand", 2, "9000000002", b1.getBranchName(), "anand@email.com", "Male", 12000.0, generateAccountNumber(b1.getBranchName())));
        b2.addCustomer(new Customer("Sravan", 3, "9000000003", b2.getBranchName(), "sravan@email.com", "Male", 15000.0, generateAccountNumber(b2.getBranchName())));
        b2.addCustomer(new Customer("Nisha", 4, "9000000004", b2.getBranchName(), "nisha@email.com", "Female", 18000.0, generateAccountNumber(b2.getBranchName())));
        b3.addCustomer(new Customer("Manoj", 5, "9000000005", b3.getBranchName(), "manoj@email.com", "Male", 20000.0, generateAccountNumber(b3.getBranchName())));
        b3.addCustomer(new Customer("Rajini", 6, "9000000006", b3.getBranchName(), "rajini@email.com", "Female", 22000.0, generateAccountNumber(b3.getBranchName())));
    }

    private static void createCustomer() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer id (number): ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter customer phone number: ");
        String number = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter customer account balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter branch name: ");
        String branchName = scanner.nextLine();

        Branch branch = bank.getBranchByName(branchName);
        if (branch == null) {
            System.out.println("Branch not found. Please create the branch first.");
            return;
        }

        String accountNumber = generateAccountNumber(branchName);
        Customer customer = new Customer(name, id, number, branchName, email, gender, balance, accountNumber);
        branch.addCustomer(customer);

        System.out.println("Customer " + name + " got created with account number: " + accountNumber);
    }

    private static void createBranch() {
        System.out.print("Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter branch manager: ");
        String manager = scanner.nextLine();
        System.out.print("Enter branch number: ");
        String branchNumber = scanner.nextLine();
        System.out.print("Enter branch IFSC code: ");
        String ifsc = scanner.nextLine();
        System.out.print("Enter branch pin code: ");
        String pin = scanner.nextLine();

        Branch branch = new Branch(branchName, manager, branchNumber, ifsc, pin);
        bank.addBranch(branch);

        System.out.println("Branch " + branchName + " created successfully.");
    }

    private static void findCustomer() {
        System.out.print("Enter customer name to search: ");
        String name = scanner.nextLine();
        for (Branch branch : bank.getBranches()) {
            for (Customer customer : branch.getCustomers()) {
                if (customer.getName().equalsIgnoreCase(name)) {
                    System.out.println("Customer found:");
                    System.out.println("Name: " + customer.getName());
                    System.out.println("Branch: " + customer.getBranch());
                    System.out.println("Account Number: " + customer.getAccountNumber());
                    return;
                }
            }
        }
        System.out.println("Customer not found.");
    }

    private static void getCustomersInBranch() {
        System.out.print("Enter branch name: ");
        String branchName = scanner.nextLine();
        Branch branch = bank.getBranchByName(branchName);
        if (branch == null) {
            System.out.println("Branch not found.");
            return;
        }
        List<Customer> customers = branch.getCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers in this branch.");
        } else {
            System.out.println("Customers in branch " + branchName + ":");
            for (Customer customer : customers) {
                System.out.println(customer.getName());
            }
        }
    }

    private static String generateAccountNumber(String branchName) {
        String prefix = branchName.replaceAll("\\s+", "").substring(0, Math.min(3, branchName.length())).toUpperCase();
        int randomNum = 100000 + random.nextInt(900000); // 6 digits
        return prefix + randomNum;
    }
}