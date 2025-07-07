import java.util.List;

class BillingEngine {
    private static BillingEngine instance;

    private BillingEngine() {}

    public static BillingEngine getInstance() {
        if (instance == null) {
            instance = new BillingEngine();
        }
        return instance;
    }

    public double generateBill(Customer customer, List<CallLog> logs) {
        return logs.stream().mapToDouble(CallLog::calculateCost).sum();
    }

    public void printBill(Customer customer, List<CallLog> logs) {
        double total = generateBill(customer, logs);
        System.out.println("--- Bill Summary --- Customer: " + customer.getName() +
                "\nPlan: " + customer.getPlan().getType() +
                "\nTotal calls: " + logs.size() +
                "\nAmount Due: Rs. " + total +
                "\n--------------------");
    }
}