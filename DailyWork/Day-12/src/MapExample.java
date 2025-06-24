import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> customer = new HashMap<>();
        customer.put(101, "Sravan");
        customer.put(102, "Kranthi");

        System.out.println(customer);

        Map<Integer, List<String>> customer1 = new HashMap<>();

        customer1.put(101, Arrays.asList("Sravan", "Ananad","Kranthi","Manoj"));

        //System.out.println(customer1);

        Map<Integer, Map<Integer,String>> customer2 = new HashMap<>();

        customer2.put(101, customer);

        //System.out.println(customer2);

        for(Map.Entry<Integer, String> e: customer.entrySet()) System.out.println(e.getKey() + " --- " + e.getValue());

        customer.putIfAbsent(104, "Chitti");
        System.out.println(customer);

        System.out.println(customer.containsKey(103));
        System.out.println(customer.containsValue("Sravan"));

    }
}
