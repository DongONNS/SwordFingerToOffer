package edu.csu.problem17;

public class Merge {
    public static ListNode merge(ListNode l1,ListNode l2){
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode mergeHead = null;
        if (l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = merge(l1.next,l2);
        }else{
            mergeHead = l2;
            mergeHead.next = merge(l1,l2.next);
        }
        return mergeHead;
    }
}
class ListNode{
    int val;
    ListNode next ;
    ListNode(int val){
        this.val = val;
    }
}
