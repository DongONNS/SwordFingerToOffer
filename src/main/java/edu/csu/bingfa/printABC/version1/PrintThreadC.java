package edu.csu.bingfa.printABC.version1;

public class PrintThreadC extends Thread{
    private PrintABC print;

    public PrintThreadC(PrintABC print){
        super();
        this.print = print;
    }

    @Override
    public void run() {
        print.printC();
    }
}
