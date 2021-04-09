package edu.csu.swordFingerOffer.ThirdPractice.list;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
import edu.csu.ListNode;

public class ReverseList {
    public ListNode ReverseList(ListNode head){
        ListNode dummy = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
