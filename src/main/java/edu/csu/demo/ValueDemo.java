package edu.csu.demo;

public class ValueDemo {
    int index = 0;

    public int method(int index){
        index++;
        return this.index;
    }

    public void print(){
        System.out.println(index++);
    }

    public static void main(String[] args) {
        ValueDemo value = new ValueDemo();
        value.method(0);
        value.print();
    }
}
