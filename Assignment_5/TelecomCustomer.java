package Assignment_5;

import java.util.*;

class TelecomCustomer {
    private final String customerId;
    final String name;

    final List<CallRecord> callHistory = Collections.synchronizedList(new LinkedList<>());
    final List<String> subscribedVAS = Collections.synchronizedList(new ArrayList<>());
    private final List<CustomerComplaint> complaints = Collections.synchronizedList(new LinkedList<>());
    private final PriorityQueue<CustomerComplaint> complaintQueue = new PriorityQueue<>();

    public TelecomCustomer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void addCall(String number, int duration) {
        callHistory.add(new CallRecord(number, duration));
    }

    public void subscribeVAS(String service) {
        synchronized (subscribedVAS) {
            if (!subscribedVAS.contains(service)) {
                subscribedVAS.add(service);
            }
        }
    }

    public void unsubscribeVAS(String service) {
        synchronized (subscribedVAS) {
            subscribedVAS.remove(service);
        }
    }

    public void fileComplaint(String description, int priority) {
        CustomerComplaint c = new CustomerComplaint(description, priority);
        complaints.add(c);
        complaintQueue.add(c);
    }

    public void viewComplaints() {
        synchronized (complaints) {
            if (complaints.isEmpty()) {
                System.out.println("No complaints.");
            } else {
                complaints.forEach(System.out::println);
            }
        }
    }

    public void processTopPriorityComplaint() {
        CustomerComplaint top = complaintQueue.poll();
        if (top != null) {
            System.out.println("Processing: " + top);
        } else {
            System.out.println("No complaints to process.");
        }
    }

    public void displaySummary() {
        System.out.println("\nCustomer ID: " + customerId + ", Name: " + name);

        System.out.println("Subscribed VAS:");
        synchronized (subscribedVAS) {
            subscribedVAS.forEach(service -> System.out.println(" - " + service));
        }

        System.out.println("Call History:");
        synchronized (callHistory) {
            callHistory.forEach(call -> System.out.println(" - " + call));
        }

        System.out.println("Complaints:");
        viewComplaints();
    }
}


