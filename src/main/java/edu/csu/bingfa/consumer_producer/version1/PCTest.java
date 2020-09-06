package edu.csu.bingfa.consumer_producer.version1;

public class PCTest {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();

        new Producer(messageQueue,1).start();
        new Consumer(messageQueue,1).start();

        new Producer(messageQueue,2).start();
        new Consumer(messageQueue,2).start();
    }
}
