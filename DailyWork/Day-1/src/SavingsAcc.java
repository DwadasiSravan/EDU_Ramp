import java.util.Arrays;
import java.util.List;

class SavingsAcc extends BankAcc {
    static final List<String> requiredDocs = Arrays.asList(
            "Proof of Identity", "Proof of Address", "PAN Card", "Photograph", "Initial Deposit"
    );

    SavingsAcc(String customerName, String branchName) {
        super(customerName, branchName, "Savings");
    }

    @Override
    public void openAcc() {
        System.out.println("\nSavings Account opened for " + customerName + " at " + branchName + " branch.");
    }

    @Override
    public void showRequiredDocs() {
        super.showRequiredDocs();
        for (String doc : requiredDocs) {
            System.out.println("- " + doc);
        }
    }
}