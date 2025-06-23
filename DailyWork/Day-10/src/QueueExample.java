import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> ticketQueue = new LinkedList<>();

        ticketQueue.add("Ticket#101 - Internet not working");
        ticketQueue.add("Ticket#102 - Slow speed");
        ticketQueue.add("Ticket#103 - Billing issue");

        System.out.println("Current Ticket Queue:");
        for (String ticket : ticketQueue) {
            System.out.println(" - " + ticket);
        }

        System.out.println("\nProcessing: " + ticketQueue.poll());

        System.out.println("\nRemaining Tickets:");
        for (String ticket : ticketQueue) {
            System.out.println(" - " + ticket);
        }
    }
}
