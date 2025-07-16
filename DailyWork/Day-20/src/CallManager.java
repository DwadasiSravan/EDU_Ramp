import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings({"java:S3077", "java:S6548"})
class CallManager {
    private static final Logger logger = LoggerFactory.getLogger(CallManager.class);


    private static volatile CallManager instance;
    private final Map<Customer, List<CallLog>> callHistory = new ConcurrentHashMap<>();

    private CallManager() {}

    public static synchronized CallManager getInstance() {
        if (instance == null) {
            synchronized (CallManager.class) {
                if (instance == null) {
                    instance = new CallManager();
                    logger.info("CallManager instance created.");
                }
            }
        }
        return instance;
    }

    public CallLog startCall(Customer caller, Customer receiver) {
        logger.info("Call started from {} to {}", caller.getName(), receiver.getName());
        return new CallLog(caller, receiver);
    }

    public void endCall(Customer caller, CallLog callLog) {
        callLog.endCall();
        callHistory
                .computeIfAbsent(caller, k -> new ArrayList<>())
                .add(callLog);
        logger.info("Call ended: {}", callLog);
    }

    public List<CallLog> getCallLogs(Customer customer) {
        return callHistory.getOrDefault(customer, Collections.emptyList());
    }

    public void printCallLogs(Customer customer) {
        logger.info("Call logs for {}:", customer.getName());
        for (CallLog log : getCallLogs(customer)) {
            logger.info("{}", log);
        }
    }

    public void deleteCustomerData(Customer customer) {
        callHistory.remove(customer);
        logger.warn("Call records deleted for {}", customer.getName());
    }
}
