import java.util.*;
import java.util.logging.*;

public class TelecomService {
    private static volatile TelecomService instance;
    private static final Logger logger = Logger.getLogger(TelecomService.class.getName());
    private final Map<String, Customer> customers = new HashMap<>();

    private TelecomService() {
        logger.setLevel(Level.INFO);
    }

    public static TelecomService getInstance() {
        if (instance == null) {
            synchronized (TelecomService.class) {
                if (instance == null) {
                    instance = new TelecomService();
                }
            }
        }
        return instance;
    }

    public void addCustomer(String name, String mobile) {
        if (!customers.containsKey(mobile)) {
            Customer customer = new Customer(name, mobile);
            customers.put(mobile, customer);
            logger.info("Added customer: " + name + " [" + mobile + "]");
        } else {
            logger.warning("Customer already exists with mobile: " + mobile);
        }
    }

    public void makeCall(String mobile, String toNumber, int duration) {
        Customer customer = customers.get(mobile);
        if (customer != null) {
            customer.addCall(new Call(toNumber, duration));
            logger.info("Recorded call for " + mobile + " to " + toNumber + " [" + duration + "s]");
        }
    }

    public void fileComplaint(String mobile, String issue) {
        Customer customer = customers.get(mobile);
        if (customer != null) {
            customer.fileComplaint(new Complaint(issue));
            logger.info("Filed complaint for " + mobile + ": " + issue);
        }
    }

    public void showCustomerDetails(String mobile) {
        Customer customer = customers.get(mobile);
        if (customer != null) {
            System.out.println("Customer: " + customer.getName());
            System.out.println("Mobile: " + customer.getMobile());
            System.out.println("Call History:");
            customer.getCallHistory().forEach(call ->
                    System.out.println(" - To: " + call.getToNumber() + ", Duration: " + call.getDuration() + "s"));
            System.out.println("Complaints:");
            customer.getComplaints().forEach(c ->
                    System.out.println(" - " + c.getIssue()));
        } else {
            System.out.println("Customer not found.");
        }
    }
}
