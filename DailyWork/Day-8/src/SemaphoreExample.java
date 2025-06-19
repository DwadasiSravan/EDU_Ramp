import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sema = new Semaphore(3);

        sema.acquire();
        System.out.println("Thread 1 is trying to acquire a permit!");
        System.out.println(" Available permits:" +sema.availablePermits());
        Thread.sleep(2000);

        sema.acquire();
        System.out.println("Thread 2 is trying to acquire a permit");
        System.out.println("Available permits:" +sema.availablePermits());

        sema.acquire();
        System.out.println("Thread 3 is trying to acquire a permit");
        System.out.println("Available permits:" +sema.availablePermits());

        sema.release();
        System.out.println("Thread 1 has released the permit");
        System.out.println(" Available permits:" +sema.availablePermits());
    }

}