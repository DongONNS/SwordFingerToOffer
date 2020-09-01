package edu.csu.bingfa.consumer_producer;

import java.util.LinkedList;

public class MessageQueue {
    private LinkedList<Message> queue;
    private static int max_limit =100;
    private int limit;

    public MessageQueue(){
        this(max_limit);
    }

    public MessageQueue(int limit){
        this.queue = new LinkedList<>();
        this.limit = limit;
    }

    public void put(Message message){
        synchronized (queue){
            // 倘若queue的消息数量超过了limit的限制，那就先wait
            while(queue.size() > limit){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //向队列中添加消息并唤醒等待线程
            queue.addLast(message);

            queue.notifyAll();
        }
    }

    public Message take(){
        synchronized (queue){
            while(queue.isEmpty()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 从队列中取出数据并唤醒等待的线程
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }
}
