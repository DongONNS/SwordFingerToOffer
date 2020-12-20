package edu.csu.swordFingerOffer.firstPractice.problem16;

import edu.csu.ListNode;

public class ReverseLists {
    public ListNode reverseList(ListNode head) {
        ListNode reverseNodeHead = null;
        ListNode node = head;
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            if(next == null)
                reverseNodeHead = node;
            node.next = prev;
            prev = node;
            node = next;
        }
        return reverseNodeHead;
    }
}
