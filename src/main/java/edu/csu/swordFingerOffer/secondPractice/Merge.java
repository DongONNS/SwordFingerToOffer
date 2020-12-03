package edu.csu.swordFingerOffer.secondPractice;

import edu.csu.ListNode;

// 递归实现链表的合并
public class Merge {
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l2;
        if (l1.val <= l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        } else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
