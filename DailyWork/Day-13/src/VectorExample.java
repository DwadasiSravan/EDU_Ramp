import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> animals = new Vector<>();
        animals.add("Dog");
        animals.add("Deer");
        animals.add("Tiger");
        animals.add("Lion");

        System.out.println(animals);
        animals.add(0, "Rabbit");
        System.out.println(animals);
        System.out.println(animals.get(3));
        System.out.println(animals.remove(1));

        System.out.println(animals.contains("cat"));
        System.out.println(animals.size());
    }
}
