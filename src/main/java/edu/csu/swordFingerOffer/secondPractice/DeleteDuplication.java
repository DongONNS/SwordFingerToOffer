package edu.csu.swordFingerOffer.secondPractice;

import edu.csu.ListNode;

public class DeleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead)
    {
        // 判空
        if(pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode next = pHead.next;
        if(pHead.val == next.val){
            while(next != null && pHead.val == next.val){
                next = next.next;
            }
            return deleteDuplication(next);
        } else{
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);

        pHead.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode listNode = deleteDuplication(pHead);
        System.out.println(listNode);
    }
}
