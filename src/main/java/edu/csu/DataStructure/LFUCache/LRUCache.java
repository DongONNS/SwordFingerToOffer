package edu.csu.DataStructure.LFUCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    private final Map<Integer,Node> cache = new HashMap();
    // 缓存中数据的数量
    private int size;

    // 缓存的大小
    private int capacity;

    // 链表头
    private Node head;

    // 链表尾部
    private Node tail;

    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 查找缓存的数据
     * @param key
     * @return
     */
    public int get(int key){
        Node node = cache.get(key);
        if (Objects.isNull(node)){
            return -1;
        }
        return node.value;
    }

    /**
     * 缓存中插入新数据
     * @param key
     * @param value
     */
    public void put(int key,int value){
        Node node = cache.get(key);
        if (Objects.isNull(node)){
            Node insertNode = new Node(key, value);
            cache.put(key,insertNode);
            addToHead(insertNode);
            size++;
            if (size > capacity){
                Node lastNode = removeTail();
                cache.remove(lastNode.key);
                size--;
            }
        } else{
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 删除链表的最后一位节点
     * @return
     */
    public Node removeTail(){
        Node lastNode = tail.pre;
        removeNode(lastNode);
        return lastNode;
    }

    /**
     * 将节点添加到链表头
     * @param node
     */
    public void addToHead(Node node){
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    /**
     * 将节点移动到head后面
     * @param node
     */
    public void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除链表中的node节点
     * @param node
     */
    public void removeNode(Node node){
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
    }

    // 链表节点
    class Node{
        public int key;
        public int value;
        public Node pre;
        public Node next;

        public Node(){}

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
}
