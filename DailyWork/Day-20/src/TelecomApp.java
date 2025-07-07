import java.util.*;
public class TelecomApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Customer> customerMap = new HashMap<>();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your mobile number: ");
        String number = scanner.nextLine();

        Customer user = new Customer(number, name);
        System.out.print("Choose your plan (Prepaid/Postpaid): ");
        String planType = scanner.nextLine();
        user.setPlan(PlanFactory.createPlan(planType));
        customerMap.put(number, user);

        while (true) {
            System.out.print("Enter name of the person you want to call (or 'exit' to quit): ");
            String receiverName = scanner.nextLine();
            if (receiverName.equalsIgnoreCase("exit")) break;

            System.out.print("Enter mobile number of " + receiverName + ": ");
            String receiverNumber = scanner.nextLine();
            Customer receiver = customerMap.getOrDefault(receiverNumber, new Customer(receiverNumber, receiverName));
            receiver.setPlan(PlanFactory.createPlan("Prepaid"));
            customerMap.put(receiverNumber, receiver);

            System.out.print("Type 'call' to start or 'back' to enter another name: ");
            String action = scanner.nextLine();
            if (!action.equalsIgnoreCase("call")) continue;

            CallManager callManager = CallManager.getInstance();
            CallLog log = callManager.startCall(user, receiver);

            System.out.println("Call in progress... type 'end' to end the call");
            while (!scanner.nextLine().equalsIgnoreCase("end")) {
                System.out.println("Waiting for 'end' command...");
            }

            callManager.endCall(user, log);
        }

        CallManager.getInstance().printCallLogs(user);
    }
}
