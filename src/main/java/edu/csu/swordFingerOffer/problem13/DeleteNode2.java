package edu.csu.swordFingerOffer.problem13;

//要求再O(1)时间内删除一个节点
//从这道题我们应该看到删除链表中的一个节点不一定非得从头开始找到它的前一个节点，
//直接将当前节点的值进行修改为后一个节点的值然后将后一个节点删除就可以了
public class DeleteNode2 {
    public static ListNode deleteNode(ListNode head,ListNode val){
        if (head == null || val == null) return null;
        if (val.next != null){ //待删除的节点不是尾节点
            ListNode next = val.next;
            val.val = next.val;
            val.next = next.next;
        }else if(head.next == null){ //我们的链表只有一个节点
            return null;
        }else{                  //待删除的节点位于链表的尾部
            ListNode curr = head;
            while(curr.next != val){
                curr = curr.next;
            }
            curr.next = null;
        }
        return head;
    }
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}
