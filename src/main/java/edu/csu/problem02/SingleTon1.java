package edu.csu.problem02;

public class SingleTon1 {
//    懒汉式
//    只是用与单线程环境下，所以不是一个很好的解法
//    懒汉式适合单线程，多线程情况下如果在创建实例对象时不加上synchronized则会导致对对象的访问不是线程安全的
//    懒汉式的优点是延时加载、缺点是应该用同步。
    private static SingleTon1 singleTon = null;
    private SingleTon1(){}
    public static synchronized SingleTon1 getInstance(){
        if (singleTon == null) singleTon = new SingleTon1();
        return singleTon;
    }

}
