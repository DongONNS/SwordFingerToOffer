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
            synchronized (this){
                while(num != 1){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("A");

                // 打印线程A执行完，通知打印B线程
                num = 2;
                this.notifyAll();
            }
        }
    }

    public void printB(){
        for(int i = 0;i < 3;i++){
            synchronized (this){
                while(num != 2){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("B");

                num = 3;
                this.notifyAll();
            }
        }
    }

    public void printC(){
        for(int i = 0;i < 3;i++){
            synchronized (this){
                while(num != 3){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("C");

                // 打印线程C执行完 通知打印A线程
                num = 1;
                this.notifyAll();
            }
        }
    }
}
