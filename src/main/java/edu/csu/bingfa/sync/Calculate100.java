package edu.csu.bingfa.sync;

public class Calculate100 {

    private static int num = 0;

    public static void main(String[] args) {
        int count = 100;
        while(count-- > 0){
            AddMethod obj = new AddMethod(count);
            obj.start();
            System.out.println(obj.getName());
        }
    }

    static class AddMethod extends Thread{

        public AddMethod(int i){
            super("Thread" + i);
        }

        public void run(){
            synchronized (AddMethod.class){
                for(int i = 0;i < 100;i++) {
                    num++;
                }
                System.out.println(num);
            }
        }
    }
}
