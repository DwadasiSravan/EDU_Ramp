import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TelecomService service = TelecomService.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your mobile number: ");
        String mobile = scanner.nextLine();

        service.addCustomer(name, mobile);

        // Dummy Data
        service.makeCall(mobile, "9998887776", 100);
        service.makeCall(mobile, "8889997775", 200);
        service.fileComplaint(mobile, "Slow Internet");
        service.fileComplaint(mobile, "No Network in basement");

        System.out.println("\nYour Details and History:");
        service.showCustomerDetails(mobile);
    }
}
