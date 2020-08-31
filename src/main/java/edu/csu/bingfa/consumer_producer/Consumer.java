package edu.csu.bingfa.consumer_producer;

public class Consumer extends Thread {
    private MessageQueue messageQueue;

    public Consumer(MessageQueue messageQueue,int seq){
        // 为消费者线程命名
        super("Consumer_" + seq);
        this.messageQueue = messageQueue;
    }

    public void run(){
        while(true){
            try {
                Message message = messageQueue.take();
                System.out.println(Thread.currentThread().getName() + " get Message Data" + message.getData());
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
