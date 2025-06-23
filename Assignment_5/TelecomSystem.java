package Assignment_5;

import java.util.Scanner;

public class TelecomSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CustomerManagement system = new CustomerManagement();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Telecom Customer Management System ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Record Call");
            System.out.println("3. Subscribe to VAS");
            System.out.println("4. Unsubscribe VAS");
            System.out.println("5. File Complaint");
            System.out.println("6. View Customer Summary");
            System.out.println("7. Show All Customers");
            System.out.println("8. Filter Customers by VAS");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addCustomer();
                case 2:
                    recordCall();
                case 3:
                    subscribeVAS();
                case 4:
                    unsubscribeVAS();
                case 5:
                    fileComplaint();
                case 6:
                    viewCustomerSummary();
                case 7:
                    system.showAllSummaries();
                case 8:
                    filterByVAS();
                case 9:
                {
                    System.out.println("Exiting...");
                    return;
                }
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addCustomer() {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        system.addCustomer(id, name);
    }

    private static void recordCall() {
        TelecomCustomer customer = getCustomer();
        if (customer == null) return;

        System.out.print("Enter number called: ");
        String number = scanner.nextLine();
        System.out.print("Enter duration in seconds: ");
        int duration = Integer.parseInt(scanner.nextLine());
        customer.addCall(number, duration);
    }

    private static void subscribeVAS() {
        TelecomCustomer customer = getCustomer();
        if (customer == null) return;

        System.out.print("Enter VAS to subscribe: ");
        String service = scanner.nextLine();
        customer.subscribeVAS(service);
    }

    private static void unsubscribeVAS() {
        TelecomCustomer customer = getCustomer();
        if (customer == null) return;

        System.out.print("Enter VAS to unsubscribe: ");
        String service = scanner.nextLine();
        customer.unsubscribeVAS(service);
    }

    private static void fileComplaint() {
        TelecomCustomer customer = getCustomer();
        if (customer == null) return;

        System.out.print("Enter complaint description: ");
        String desc = scanner.nextLine();
        System.out.print("Enter priority (1=High, 2=Med, 3=Low): ");
        int priority = Integer.parseInt(scanner.nextLine());
        customer.fileComplaint(desc, priority);
    }

    private static void viewCustomerSummary() {
        TelecomCustomer customer = getCustomer();
        if (customer != null) {
            customer.displaySummary();
        }
    }

    private static void filterByVAS() {
        System.out.print("Enter VAS name to filter by: ");
        String vas = scanner.nextLine();
        system.filterCustomersByVAS(vas);
    }

    private static TelecomCustomer getCustomer() {
        System.out.print("Enter customer ID: ");
        String id = scanner.nextLine();
        TelecomCustomer customer = system.getCustomer(id);
        if (customer == null) {
            System.out.println("Customer not found.");
        }
        return customer;
    }
}
