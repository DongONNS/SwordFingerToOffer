package edu.csu.swordFingerOffer.secondPractice;

import edu.csu.ListNode;

// 循环实现合并有序列表
public class MergeVersionII {
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        }
        if (l2 != null){
            cur.next = l2;
        }
        return head.next;
    }
}
