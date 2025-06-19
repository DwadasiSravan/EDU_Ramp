import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdCnsmrUsingLambdaAndBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        //Producer
        Runnable producer = () -> {
            int value = 0;
            try{
                while(true){
                    queue.put(value);
                    System.out.println("Produced Count : " + value);
                    value++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //Consumer
        Runnable consumer = () -> {
            try{
                while(true){
                    int value = queue.take();
                    System.out.println("Consumed Count : " + value);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
