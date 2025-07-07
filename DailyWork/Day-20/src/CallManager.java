import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class CallManager {
    private static volatile CallManager instance;
    private final Map<Customer, List<CallLog>> callHistory = new ConcurrentHashMap<>();

    private CallManager() {}

    public static CallManager getInstance() {
        if (instance == null) {
            synchronized (CallManager.class) {
                if (instance == null) {
                    instance = new CallManager();
                }
            }
        }
        return instance;
    }

    public CallLog startCall(Customer caller, Customer receiver) {
        return new CallLog(caller, receiver);
    }

    public void endCall(Customer caller, CallLog callLog) {
        callLog.endCall();
        callHistory.computeIfAbsent(caller, k -> new ArrayList<>()).add(callLog);
        System.out.println("Call ended: " + callLog);
    }

    public List<CallLog> getCallLogs(Customer customer) {
        return callHistory.getOrDefault(customer, Collections.emptyList());
    }

    public void printCallLogs(Customer customer) {
        System.out.println("Call logs for " + customer.getName() + ":");
        for (CallLog log : getCallLogs(customer)) {
            System.out.println(log);
        }
    }

    public void deleteCustomerData(Customer customer) {
        callHistory.remove(customer);
        System.out.println("Call records deleted for " + customer.getName());
    }
}