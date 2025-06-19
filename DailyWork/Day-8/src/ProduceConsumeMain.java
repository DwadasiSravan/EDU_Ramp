public class ProduceConsumeMain {
    public static void main(String[] args) {
        Producer_Consumer prod1 = new Producer_Consumer();

        new ProducerThread(prod1).start();
        new ConsumerThread(prod1).start();
    }
}
