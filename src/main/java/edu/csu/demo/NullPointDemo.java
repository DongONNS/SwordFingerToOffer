package edu.csu.demo;

public class NullPointDemo {
    public void print(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        NullPointDemo demo = null;
        demo.print("hello");
    }
}
