package edu.csu.problem02;

public class SingleTon2 {

//     懒汉式的改进：我们可以将为方法加锁改为为代码块加锁，避免每一次获取对象都将其加锁
//    下面这种做法能够在恨到程度上盖上上面的单例方式
    private static SingleTon2 singleTon = null;
    private SingleTon2(){}
    private static final Object obj = new Object();
    public static SingleTon2  getInstance(){
        if (singleTon == null){
            synchronized (obj){
                singleTon = new SingleTon2();
            }
        }
        return singleTon;
    }
}
