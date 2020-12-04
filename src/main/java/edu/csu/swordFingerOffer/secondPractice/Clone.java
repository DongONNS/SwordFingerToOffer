package edu.csu.swordFingerOffer.secondPractice;

import edu.csu.RandomListNode;

import java.time.temporal.ChronoUnit;

public class Clone {
    public RandomListNode clone(RandomListNode pHead){
        if (pHead == null)
            return null;
        // 插入复制节点
        RandomListNode cur = pHead;
        while(cur != null){
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        // 建立random连接
        cur = pHead;
        while(cur != null){
            RandomListNode clone = cur.next;
            if (cur.random != null){
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        // 拆分链表
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(cur.next != null){
            RandomListNode next = cur.next;
            cur.next = cur.next.next;
            cur = next;
        }
        return pCloneHead;
    }
}
