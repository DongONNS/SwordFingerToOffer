package edu.csu.swordFingerOffer.firstPractice.problem15;

import edu.csu.ListNode;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null) return null;
        ListNode headNode = head;
        for(int i = 1;i < k;i++){
            if(headNode.next != null){
                headNode = headNode.next;
            }else
                return null;

        }
        ListNode tailNode = head;
        while(headNode.next != null){
            tailNode = tailNode.next;
            headNode = headNode.next;
        }
        return tailNode;
    }
}
