import java.time.Duration;
import java.time.LocalDateTime;

class CallLog {
    private final Customer caller;
    private final Customer receiver;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public CallLog(Customer caller, Customer receiver) {
        this.caller = caller;
        this.receiver = receiver;
        this.startTime = LocalDateTime.now();
    }

    public void endCall() {
        this.endTime = LocalDateTime.now();
    }

    public long getDurationMinutes() {
        return Duration.between(startTime, endTime).toSeconds();
    }

    public double calculateCost() {
        return getDurationMinutes() * caller.getPlan().getRatePerSecond();
    }

    @Override
    public String toString() {
        return caller.getName() + " -> " + receiver.getName() + " | Start: " + startTime + ", End: " + endTime + ", Duration: " + getDurationMinutes() + " Seconds";
    }
}