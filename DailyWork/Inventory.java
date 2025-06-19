import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {

    private int stock = 100 ;
    private final Lock lock = new ReentrantLock();

    public  void purchase(String user,int qty) {
        lock.lock();
        try {
            if(stock >= qty) {
                System.out.println(user  + "purchased" +qty + "item");
                stock -= qty;
                System.out.println(stock);
            }
            else {
                System.out.println("Not purchased!");
            }
        }
        finally {
            lock.unlock();
        }
    }

    public int getStock() {
        return stock;
    }

    public static void main(String[] args) {

    }
}