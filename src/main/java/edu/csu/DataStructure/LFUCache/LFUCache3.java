package edu.csu.DataStructure.LFUCache;

import java.util.HashMap;
import java.util.Map;

public class LFUCache3 {
    private Map<Integer,Node> cache;
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LFUCache3 (int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // 初始化头节点和尾节点，并作为哨兵节点
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        Node node = cache.get(key);
        if (node == null) return -1;
        node.freq++;
        moveToPosition(node);
        return node.value;
    }

    public void put(int key,int value){
        if (capacity == 0) return;
        Node node = cache.get(key);

        // 如果node不为空，那么直接更行node
        if (node != null){
            node.value = value;
            node.freq++;
            moveToPosition(node);
        }else {
            // 如果元素满了，那么删除最近最久未使用的元素,
            // 也就是删除head.next节点
            if (size == capacity){
                cache.remove(head.next.key);
                removeNode(head.next);
                size--;
            }

            // 添加新节点
            Node newNode = new Node(key, value);
            addNode(newNode);
            cache.put(key,newNode);
            size++;
        }
    }

    // 找到第一个比当前node频次大的节点或者tail节点，然后插入到它前面
    public void moveToPosition(Node node){
        Node nextNode = node.next;

        // 把当前要移动位置的节点删除
        removeNode(node);

        // 遍历到符合要求的节点
        while(node.freq >= nextNode.freq && nextNode != tail){
            nextNode = nextNode.next;
        }

        // 将当前元素插入到nextNode前面
        node.pre = nextNode.pre;
        node.next = nextNode;
        nextNode.pre.next = node;
        nextNode.pre = node;
    }

    // 添加元素，并移动到合适的位置
    public void addNode(Node node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        moveToPosition(node);
    }


    // 移除元素
    public void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 用于存储新加进来的节点
    class Node{
        int key;
        int value;
        int freq = 1;
        // 当前节点的前一个节点
        Node pre;
        // 当前节点的后一个节点
        Node next;

        public Node(){}

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
}
