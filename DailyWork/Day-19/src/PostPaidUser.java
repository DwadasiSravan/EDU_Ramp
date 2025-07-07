public class PostPaidUser implements Subscriber{

    private String name;

    public PostPaidUser(String name){
        super();
        this.name = name;
    }

    public void update(String message){
        System.out.println("Post paid User [ " + name + " ] received alert " + message);
    }
}
