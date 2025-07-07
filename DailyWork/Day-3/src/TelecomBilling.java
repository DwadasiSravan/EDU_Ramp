public class TelecomBilling {
    public static double taxRate = 0.18;

    private String customerName;
    private int callDurationInMinutes;
    private double ratePerMinute;

    public TelecomBilling(String name, int duration, double rate) {
        this.customerName = name;
        this.callDurationInMinutes = duration;
        this.ratePerMinute = rate;
    }

    public double calculateBill() {
        double baseAmount = 0.0;
        double tax = 0.0;
        if(taxRate>0) {
            callDurationInMinutes *= ratePerMinute;
            baseAmount *= taxRate;
        }else {
            System.out.println("Please enter the tax!");
        }
        return baseAmount + tax;
    }

    public void printBill() {
        System.out.println("Customer: " + customerName);
        System.out.println("Call Duration: " + callDurationInMinutes + " mins");
        System.out.println("Rate Per Minute: " + ratePerMinute);
        System.out.println("Total Bill with tax: " + calculateBill());
    }

    public static void main(String[] args) {
        TelecomBilling customer1 = new TelecomBilling("Anand", 30, 0.50);
        customer1.printBill();

        TelecomBilling customer2 = new TelecomBilling("Kranthi", 60, 0.45);
        customer2.printBill();
    }


}