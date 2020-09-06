package edu.csu.demo;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

public class SyncTest {

    public static synchronized void method1(){
        System.out.println("synchronized修饰的静态方法");
    }

    public static void method2(){
        System.out.println("普通方法");
    }

    public static void main(String[] args) {
        SyncTest syn = new SyncTest();

        syn.method1();

        syn.method2();
    }
}
