import java.util.*;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter branch name: ");
            String branch = sc.nextLine();

            System.out.print("Enter Account type (Savings/Current): ");
            String accType = sc.nextLine();

            BankAcc Acc = null;

            switch (accType.trim().toLowerCase()) {
                case "savings":
                    Acc = new SavingsAcc(name, branch);
                    break;
                case "current":
                    Acc = new CurrentAcc(name, branch);
                    break;
                default:
                    System.out.println("Invalid Account type. Try again.");
                    continue;
            }

            Acc.showRequiredDocs();

            System.out.println("\nEnter the Documents you are submitting (comma separated):");
            String docsInput = sc.nextLine();
            List<String> providedDocs = Arrays.asList(docsInput.split("\\s*,\\s*"));

            DocVerifier verifier = (provided, required) -> {
                for (String doc : required) {
                    boolean found = false;
                    for (String p : provided) {
                        if (p.equalsIgnoreCase(doc)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) return false;
                }
                return true;
            };

            List<String> requiredDocs = (Acc instanceof SavingsAcc)
                    ? SavingsAcc.requiredDocs
                    : CurrentAcc.requiredDocs;

            if (verifier.verify(providedDocs, requiredDocs)) {
                Acc.openAcc();
            } else {
                System.out.println("\nAccount cannot be opened. Missing required Documents.");
            }

            System.out.print("\nDo you want to open another Account? (yes/no): ");
            String again = sc.nextLine();
            if (!again.equalsIgnoreCase("yes")) {
                break;
            }
        }
        sc.close();
    }
}
