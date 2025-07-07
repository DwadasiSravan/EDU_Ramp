abstract class BankAcc implements AccOperations {
    String customerName;
    String branchName;
    String AccType;

    BankAcc(String customerName, String branchName, String AccType) {
        this.customerName = customerName;
        this.branchName = branchName;
        this.AccType = AccType;
    }

    public void showRequiredDocs() {
        System.out.println("\nRequired Documents for " + AccType + " Acc:");
    }
}