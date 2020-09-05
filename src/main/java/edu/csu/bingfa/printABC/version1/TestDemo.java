package edu.csu.bingfa.printABC.version1;

public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        // 从打印A开始
        int num = 1;

        PrintABC print = new PrintABC(num);

        PrintThreadA printA = new PrintThreadA(print);
        PrintThreadA printB = new PrintThreadA(print);
        PrintThreadA printC = new PrintThreadA(print);

        printA.start();
        Thread.sleep(50);

        printB.start();
        Thread.sleep(50);

        printC.start();
    }
}
