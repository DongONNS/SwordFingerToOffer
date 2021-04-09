package edu.csu.swordFingerOffer.ThirdPractice.list;

import edu.csu.ListNode;

public class FindKthToTail {
    public ListNode findKthToTail(ListNode pHead, int k){
        ListNode slow = pHead,fast = pHead;
        while(k-- > 0){
            if (fast != null){
                fast = fast.next;
            }else {
                return null;
            }
        }

        // 快慢指针同步前进
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
