public class CorporateClient implements Subscriber{
    private String company;

    public CorporateClient(String company){
        super();
        this.company = company;
    }
    @Override
    public void update(String message){
        System.out.println("Post paid User [ " + company + " ] received alert " + message);
    }
}
