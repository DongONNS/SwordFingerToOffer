package edu.csu.problem02;

public class SingleTon4 {
//    使用饿汉式的唯一缺点就是创建时机太早了，没有实现按需分配，下面的这个方法则可以很好的改善这一点
    private static SingleTon4 singleTon = null;
    private SingleTon4(){}
    public SingleTon4 getSingleTon(){
        return SingleTonHolder.instance;
    }
    private static class SingleTonHolder{
        //对类的主动使用才会创建对象;
        static SingleTon4 instance = new SingleTon4();
    }
}
