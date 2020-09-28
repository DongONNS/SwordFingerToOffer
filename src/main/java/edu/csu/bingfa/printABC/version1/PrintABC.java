package edu.csu.bingfa.printABC.version1;

public class PrintABC {
    // 用于指示当前打印第几个字母
    int num;

    public PrintABC(int num){
        super();
        this.num = num;
    }

    public void printA(){
        for(int i = 0;i < 3;i++){

            // 互斥进入打印A的流程
            synchronized (this){
                while(num != 1){
                    try {
                        // 释放锁，条件等待
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("A");

                // 打印线程A执行完，通知打印B线程
                num = 2;
                // 释放锁
                this.notifyAll();
            }

        }
    }

    public void printB(){
        for(int i = 0;i < 3;i++){

            // 互斥进入打印流程
            synchronized (this){
                while(num != 2){
                    try {
                        // 释放锁，条件等待
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("B");

                num = 3;
                // 释放锁，唤醒其他线程
                this.notifyAll();
            }
        }
    }

    public void printC(){
        for(int i = 0;i < 3;i++){

            // 互斥进入打印C的流程
            synchronized (this){
                while(num != 3){
                    try {
                        // 释放锁 条件等待
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("C");

                // 打印线程C执行完 通知打印A线程
                num = 1;
                // 释放锁 唤醒其他线程
                this.notifyAll();
            }
        }
    }
}
