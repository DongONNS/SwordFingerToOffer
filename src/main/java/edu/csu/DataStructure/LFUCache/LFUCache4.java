package edu.csu.DataStructure.LFUCache;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LFUCache4  {
    // 缓存了所有元素的NODE
    Map<Integer, Node> cache;

    // 优先队列
    Queue<Node> queue;

    // 缓存cache的数量
    int capacity;

    // 当前缓存的元素个数
    int size;

    // 全局自增
    int index = 0;

    // 初始化
    public LFUCache4(int capacity){
        this.capacity = capacity;
        if (capacity > 0){
            queue = new PriorityQueue<>(capacity);
        }
        cache = new HashMap<>();
    }

    public int get(int key){
        Node node = cache.get(key);
        // node不存在，返回-1
        if (node == null){
            return -1;
        }

        // 没访问一次，频次和全局index都自增
        node.index = index++;
        node.freq++;

        // 每次都remove再offer,让优先队列能够对当前node重排序
        // 不然的话比较的freq和index就是不准确的
        queue.remove(node);
        queue.offer(node);

        return node.value;
    }

    public void put(int key,int value){
        // 容量为0直接返回
        if (capacity == 0) return;
        Node node = cache.get(key);

        // 如果node存在,则更新它的值
        if (node != null){
            node.value = value;
            node.freq ++;
            node.index = index++;
            queue.remove(node);
            queue.offer(node);
        }else{
            // 如果cache满了，则从优先队列中取出一个元素，这个元素一定是频次最小，最久未访问的元素
            if (size == capacity){
                cache.remove(queue.poll().key);
                size--;
            }
            // 否则，cache没满，说明可以添加元素，于是创建一个新的node，添加到优先队列中
            Node newNode = new Node(key, value, index++);
            queue.offer(newNode);
            cache.put(key,newNode);

            // 同时size+1;
            size ++;
        }


    }
















    //必须实现Comparable接口才可以用于排序
    private class Node implements Comparable<Node>{

        int key;
        int value;
        int freq = 1;
        int index;

        public Node(){ }

        public Node (int key,int value,int index){
            this.key = key;
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo (Node o) {
            // 优先比较频次，频次相同再比较index
            int minus = this.freq - o.freq;

            return minus == 0 ? this.index - o.index : minus;
        }
    }
}
