public class PrepaidUser implements Subscriber {
    private String name;

    public PrepaidUser(String name) {
        super();
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Prepaid User ["+ name +"] received alert "+message);
    }
}