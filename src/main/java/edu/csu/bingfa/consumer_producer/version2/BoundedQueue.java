package edu.csu.bingfa.consumer_producer.version2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue {
    Object[] items;

    // 添加数据的位置索引
    private int addIndex;

    // 删除数据的位置索引
    private int removeIndex;

    // 数组中的元素数量
    private int count;

    public BoundedQueue(int size){
        items = new Object[size];
    }


    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public void add(Object item){
        lock.lock();
        try {
            // 如果数组已经满了，那么无法添加元素，将其进行阻塞
            while(count == items.length)
                notFull.await();

            // 将数字添加到索引位置处
            items[addIndex] = item;

            // 更新count的数量
            ++count;

            // 数字如果下一位已经越界了，那么我们从头开始将数字添加到数组中
            if(++addIndex == items.length)
                addIndex = 0;

            // 唤醒阻塞的添加方法
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private Object remove(){
        lock.lock();

        Object val;

        try {
            while(count == 0)
                notEmpty.await();

            val = items[removeIndex];
            items[removeIndex] = null;

            // 修改索引位置
            if (++removeIndex == items.length)
                removeIndex = 0;

            count--;

            notFull.signal();

            return val;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return new Object();
    }
}
