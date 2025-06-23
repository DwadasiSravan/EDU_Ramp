package Assignment_5;

public class CustomerComplaint implements Comparable<CustomerComplaint> {
    private final String description;
    private final int priority;

    public CustomerComplaint(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    @Override
    public int compareTo(CustomerComplaint other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "[Priority " + priority + "] " + description;
    }
}