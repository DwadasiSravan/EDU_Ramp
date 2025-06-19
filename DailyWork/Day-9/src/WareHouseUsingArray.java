public class WareHouseUsingArray {
    String[] productSlots = new String[100];

    void storeProduct(int slot, String product){
        productSlots[slot] = product;
    }

    String getProduct(int slot){
        return productSlots[slot];
    }

    public static void main(String[] args) {
        WareHouseUsingArray wareHouse = new WareHouseUsingArray();
        wareHouse.storeProduct(20,"Soap");
        System.out.println(wareHouse.getProduct(20));

    }
}
