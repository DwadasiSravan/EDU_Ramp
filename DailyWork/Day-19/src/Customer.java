import java.util.*;

public class Customer {
    private final String name;
    private final String mobile;
    private final List<Call> callHistory = new ArrayList<>();
    private final List<Complaint> complaints = new ArrayList<>();

    public Customer(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public void addCall(Call call) {
        callHistory.add(call);
    }

    public void fileComplaint(Complaint complaint) {
        complaints.add(complaint);
    }

    public List<Call> getCallHistory() {
        return callHistory;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }
}
