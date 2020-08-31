package edu.csu.bingfa.consumer_producer;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {
    private MessageQueue messageQueue;

    private AtomicInteger count = new AtomicInteger(0);

    public Producer(MessageQueue messageQueue,int seq){
        super("Producer_" + seq);
        this.messageQueue = new MessageQueue();
    }

    public void run(){
        while(true){
            try {
                Message message = new Message("Message--" + count.getAndIncrement());
                messageQueue.put(message);
                System.out.println(Thread.currentThread().getName() + "put messageData" + message.getData());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
