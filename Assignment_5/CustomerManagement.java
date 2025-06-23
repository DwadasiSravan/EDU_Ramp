package Assignment_5;

import java.util.Map;
import java.util.concurrent.*;

class CustomerManagement {
    private final Map<String, TelecomCustomer> customers = new ConcurrentHashMap<>();

    public void addCustomer(String id, String name) {
        customers.putIfAbsent(id, new TelecomCustomer(id, name));
    }

    public TelecomCustomer getCustomer(String id) {
        return customers.get(id);
    }

    public void showAllSummaries() {
        customers.forEach((id, customer) -> customer.displaySummary());
    }

    public void filterCustomersByVAS(String vas) {
        System.out.println("\nCustomers subscribed to " + vas + ":");
        customers.values().stream()
                .filter(c -> {
                    synchronized (c.subscribedVAS) {
                        return c.subscribedVAS.contains(vas);
                    }
                })
                .forEach(c -> System.out.println(" - " + c.name));
    }
}
