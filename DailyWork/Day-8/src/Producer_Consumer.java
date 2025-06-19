import java.util.LinkedList;

public class Producer_Consumer {
    private static final int capacity = 10;

    private final LinkedList<Integer> buffer = new LinkedList<>();

    synchronized public void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity){
            wait(); // Because as the size of the buffer is equal to capacity we don't have ay extra so we make it wait and then add the value to the buffer.
        }
        buffer.add(value);
        System.out.println("Product produced : " + value);
        notify(); //Intercommunication btw the Threads
    }
    synchronized public void consume() throws InterruptedException {
        while (buffer.isEmpty()){
            wait();
        }
        int value = buffer.removeFirst();
        System.out.println("product consumed : " + value);
        notify();
    }
}


