package edu.csu.swordFingerOffer.secondPractice;

import edu.csu.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode head){
        // 判断是否需要进行反转
        if (head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(next);
        next.next = head;
        return newHead;
    }
}
