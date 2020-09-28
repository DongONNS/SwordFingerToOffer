package edu.csu.bingfa.printABC.version1;

public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        // 当前正在执行的线程的标记
        int num = 1;

        PrintABC print = new PrintABC(num);

        PrintThreadA printA = new PrintThreadA(print);
        PrintThreadB printB = new PrintThreadB(print);
        PrintThreadC printC = new PrintThreadC(print);

        printA.start();
        Thread.sleep(50);

        printB.start();
        Thread.sleep(50);

        printC.start();
    }
}
