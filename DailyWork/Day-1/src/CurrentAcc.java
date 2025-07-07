import java.util.Arrays;
import java.util.List;

class CurrentAcc extends BankAcc {
    static final List<String> requiredDocs = Arrays.asList(
            "Proof of Identity", "Proof of Address", "PAN Card", "Business Registration Certificate",
            "Partnership Deed/Certificate of Incorporation", "Board Resolution", "GST Certificate", "Photograph", "Initial Deposit"
    );

    CurrentAcc(String customerName, String branchName) {
        super(customerName, branchName, "Current");
    }

    @Override
    public void openAcc() {
        System.out.println("\nCurrent Account opened for " + customerName + " at " + branchName + " branch.");
    }

    @Override
    public void showRequiredDocs() {
        super.showRequiredDocs();
        for (String doc : requiredDocs) {
            System.out.println("- " + doc);
        }
    }
}
