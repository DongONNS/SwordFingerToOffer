package edu.csu.swordFingerOffer.problem02;

public class SingleTon3 {
//    饿汉式
//    饿汉式是线程安全的,在类创建的同时就已经创建好一个静态的对象供系统使用,以后不在改变。
//    变量声明和构造方法必须设为私有，否则无法实现单例
    private static SingleTon3 singleTon = new SingleTon3();
    private SingleTon3(){}
    public SingleTon3 getInstance() {
        return singleTon;
    }
}
