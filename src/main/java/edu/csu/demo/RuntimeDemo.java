package edu.csu.demo;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class RuntimeDemo {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        System.out.println("可用的处理器数量为：" + Runtime.getRuntime().availableProcessors());
    }
}
