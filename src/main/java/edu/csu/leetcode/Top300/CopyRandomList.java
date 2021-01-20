package edu.csu.leetcode.Top300;

import edu.csu.RandomListNode;

import java.util.HashMap;
import java.util.Random;

public class CopyRandomList {

    HashMap<RandomListNode, RandomListNode> visit = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head){
        if (head == null) return null;

        // 初始化链表头
        RandomListNode oldNode = head;
        RandomListNode newNode = new RandomListNode(oldNode.label);

        this.visit.put(oldNode,newNode);

        while(oldNode != null){
            newNode.next = this.getCloneNode(oldNode.next);
            newNode.random = this.getCloneNode(oldNode.random);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visit.get(head);
    }

    /**
     * 根据传入节点，生成它的下一个节点
     * @param node
     * @return
     */
    private RandomListNode getCloneNode(RandomListNode node){
        if (node == null) return null;
        if (this.visit.containsKey(node)){
            return this.visit.get(node);
        }else{
            this.visit.put(node,new RandomListNode(node.label));
            return this.visit.get(node);
        }
    }
}
