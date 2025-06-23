import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> taskList = new LinkedList<>();

        taskList.add("Login");
        taskList.add("Browse Products");
        taskList.add("Add to Cart");
        taskList.add("Checkout");

        System.out.println("User Action History (in order):");
        for (String task : taskList) {
            System.out.println(" - " + task);
        }

        System.out.println("\nMost Recent Action: " + taskList.getLast());
    }
}

