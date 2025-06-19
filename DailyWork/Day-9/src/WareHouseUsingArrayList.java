import java.util.ArrayList;
import java.util.List;

public class WareHouseUsingArrayList {
    List<String> productSlots = new ArrayList<>();

    void storeProduct(int slot, String product){
        productSlots.add(slot,product);
    }

    String getProduct(int slot){
        return productSlots.get(slot);
    }

    public static void main(String[] args) {
        WareHouseUsingArrayList wareHouseUsingArrayList = new WareHouseUsingArrayList();

        wareHouseUsingArrayList.storeProduct(0, "Shampoo");
        System.out.println(wareHouseUsingArrayList.getProduct(0));
    }
}
