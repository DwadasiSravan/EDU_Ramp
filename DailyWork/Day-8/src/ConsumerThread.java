public class ConsumerThread extends Thread{
     Producer_Consumer pc;

    public ConsumerThread(Producer_Consumer pc) {
        super();
        this.pc = pc;
    }

    public void run(){
        try{
            while (true){
                pc.consume();
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
