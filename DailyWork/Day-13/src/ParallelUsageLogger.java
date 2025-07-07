import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelUsageLogger {
    private static final Vector<UsageRecord> usageRecords = new Vector<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println("Enter number of usage events to simulate:");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter usage type (CALL/SMS):");
            String type = scanner.nextLine().toUpperCase();

            System.out.println("Enter customer ID:");
            String customerId = scanner.nextLine();

            System.out.println(type.equals("CALL") ? "Enter call duration in seconds:" : "Enter SMS length:");
            int value = scanner.nextInt();
            scanner.nextLine();

            executor.submit(() -> {
                UsageRecord record = new UsageRecord(type, customerId, value);
                usageRecords.add(record);
                System.out.println("Logged: " + record);
            });
        }

        executor.shutdown();

        System.out.println("\nAll usage records logged:");
        for (UsageRecord record : usageRecords) {
            System.out.println(record);
        }

        scanner.close();
    }
}
