public class ProducerThread extends Thread{
    private Producer_Consumer pc;

    public ProducerThread(Producer_Consumer pc){
        super();
        this.pc = pc;
    }
    public void run(){
        int value = 0;
        try{
            while(true) {
                pc.produce(value++);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }

    }
}
