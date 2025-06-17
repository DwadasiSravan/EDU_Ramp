import java.util.HashMap;
import java.util.*;

public class BillingSystem {
    
    static double tax = 0.18;
    String item;
    int quantity;
    int total;

    public BillingSystem(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    void pre_total(int price){
        if(quantity > 0){
            total = price * quantity;
            System.out.println("Item total  ------ " + total);
        }else System.out.println("Enter Quantity more than zero");
    }

    void total(){
        total = (int) (total + (total * tax));
        System.out.println("GST         ------ " + tax);
        System.out.println("Grand Total ------ " + total);
    }

    public static void main(String[] args) {

        HashMap<String, Integer> list = new HashMap<>();
        list.put("Chicken Biryani", 250);
        list.put("Panner Biryani", 200);
        list.put("Coco cola", 40);
        list.put("Lemon Soda", 20);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your mobile number: ");
        String number = sc.nextLine();

        System.out.println();

        System.out.println("PRODUCTS AVAILABLE: ");

        for(String key : list.keySet()){
            System.out.println(key + "       ---------------------------- $" + list.get(key));
        }

        System.out.println("*********************************************************************************");

        System.out.println("Enter the item name: ");
        String item = sc.nextLine();
        System.out.println("Enter the quantity: ");
        int quantity = sc.nextInt();

        System.out.println();
        System.out.println("*********************************************************************************");
        System.out.println("*************************************** BILL ************************************");
        System.out.println("Customer Name:          " + name);
        System.out.println("Customer Mobile number: " + number);
        System.out.println("Items: ");
        System.out.println( item + " * " + quantity);
        BillingSystem order = new BillingSystem(item, quantity);
        order.pre_total(list.get(item));
        order.total();
        System.out.println();
        System.out.println("************************************ THANK YOU **********************************");


    }
}