package edu.csu.Singleton;

public class DoubleCheckLock {
    // volatile用于防止重定向排序
    private volatile static DoubleCheckLock instance = null;

    //构造方法
    public DoubleCheckLock(){

    }

    public static DoubleCheckLock getInstance(){
        // 这里是为了避免大量方法使用synchronized会导致线程等待
        if (instance == null){
            synchronized (DoubleCheckLock.class){
                // 这里的判断是因为大量线程可能在等待进入synchronized中
                // 导致已经创建了实例之后再次创建实例
                if (instance == null){
                    instance = new DoubleCheckLock();
                }
            }
        }


        return instance;
    }
}
