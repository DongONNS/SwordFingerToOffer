package edu.csu.swordFingerOffer.secondPractice;

import edu.csu.ListNode;

/**
 * 查找两个列表的第一个公共节点
 */
public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1,ListNode pHead2){
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        //如果两个链表没有交点的话会在经历完 l1 -> l1,l2 -> l1 之后两者都是null而返回
        while(l1 != l2){
            l1 = l1 == null ? pHead2 : l1.next;
            l2 = l2 == null ? pHead1 : l2.next;
        }
        return l1;
    }
}
