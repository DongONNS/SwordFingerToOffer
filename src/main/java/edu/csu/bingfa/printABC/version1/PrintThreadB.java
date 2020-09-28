package edu.csu.bingfa.printABC.version1;

public class PrintThreadB extends Thread{
    private PrintABC print;

    public PrintThreadB(PrintABC print){
        super();
        this.print = print;
    }

    @Override
    public void run() {
        print.printB();
    }
}
