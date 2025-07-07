import java.util.*;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Scanner;

class UsageRecord {
    String type;
    String customerId;
    LocalDateTime timestamp;
    int value;

    UsageRecord(String type, String customerId, int value) {
        this.type = type;
        this.customerId = customerId;
        this.timestamp = LocalDateTime.now();
        this.value = value;
    }

    @Override
    public String toString() {
        return "UsageRecord{" +
                "type='" + type + '\'' +
                ", customerId='" + customerId + '\'' +
                ", timestamp=" + timestamp +
                ", value=" + value +
                '}';
    }
}