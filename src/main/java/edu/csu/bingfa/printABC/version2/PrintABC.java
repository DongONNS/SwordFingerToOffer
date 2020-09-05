package edu.csu.bingfa.printABC.version2;

public class PrintABC implements Runnable {
    private String name;
    private Object pre;
    private Object self;

    public PrintABC(String name,Object pre,Object self){
        this.name = name;
        this.pre = pre;
        this.self = self;
    }

    @Override
    public void run() {
        // 实现循环打印十次
        int count = 10;

        while(count > 0){
            synchronized (pre){

                synchronized (self){

                    System.out.println("第" +  (11 - count)+ "次打印：" + name);
                    count--;

                    // 当前打印线程结束，唤醒等待当前锁的其他线程
                    self.notifyAll();
                }

                try {
                    // 如果count == 0,表示这是最后一次打印操作
                    // 通过notifyAll操作释放对象锁,否则就算结束打印了线程也没有停止
                    if (count == 0)
                        pre.notifyAll();
                    // 当前打印结束，让线程陷入阻塞状态，释放锁
                    // 直到有其他的持有pre的线程释放锁将它唤醒
                    else
                        pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
