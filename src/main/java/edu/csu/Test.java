package edu.csu;

import com.sun.beans.decoder.ValueObject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {

    static String str = new String("good");
    static char[] ch = {'a','b','c'};

    public static void main(String[] ars) {

        Test test = new Test();
        test.change(str,ch);

        System.out.println(test.str + " and " + test.ch[0] + test.ch[1] + test.ch[2]);
    }

    public void change(String str,char[] ch){
        str = "test ok";
        ch[0] = 'g';
    }

    private void demo(String string) throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lockInterruptibly();

        //读写公平锁
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
        reentrantReadWriteLock.readLock();
        reentrantReadWriteLock.writeLock();

        Condition condition = lock.newCondition();

        ValueObject valueObject = new ValueObject() {
            @Override
            public Object getValue() {
                return null;
            }

            @Override
            public boolean isVoid() {
                return false;
            }
        };
    }
}
