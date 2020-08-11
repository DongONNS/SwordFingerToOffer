package edu.csu.Singleton;

public class StaticClassSingleton {
    private StaticClassSingleton(){

    }

    // 静态类，值会创建一次实例
    private static class SingletonHolder{
        private static final StaticClassSingleton instance = new StaticClassSingleton();
    }

    public static StaticClassSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
