package edu.csu.bingfa.printABC.version1;

public class PrintThreadA extends Thread{
    PrintABC print;

    public PrintThreadA(PrintABC print){
        super();
        this.print = print;
    }

    @Override
    public void run() {
        print.printA();
    }
}
