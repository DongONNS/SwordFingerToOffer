package edu.csu.bingfa.printABC.version2;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        PrintABC printA = new PrintABC("A",c,a);
        PrintABC printB = new PrintABC("B",a,b);
        PrintABC printC = new PrintABC("C",b,c);

        new Thread(printA).start();
        Thread.sleep(10);

        new Thread(printB).start();
        Thread.sleep(10);

        new Thread(printC).start();

    }
}
