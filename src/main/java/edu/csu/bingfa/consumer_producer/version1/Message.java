package edu.csu.bingfa.consumer_producer.version1;

public class Message {
    private String data;

    public Message(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }
}
