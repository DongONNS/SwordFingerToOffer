package edu.csu.bingfa.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncExample {
    public void func1(){
        synchronized (this){
            for (int i = 0;i < 10;i++){
                System.out.print(i +" ");
            }
        }
    }

    public static void main(String[] args) {
        SyncExample syncExample1 = new SyncExample();
        SyncExample syncExample2 = new SyncExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> syncExample1.func1());
        executorService.execute(() -> syncExample2.func1());
    }
}
