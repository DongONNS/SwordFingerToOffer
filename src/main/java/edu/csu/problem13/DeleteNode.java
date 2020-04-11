package edu.csu.problem13;

public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        ListNode curr = pre.next;
        while(curr!=null){
            if(curr.val == val){
                pre.next = curr.next;
                return node.next;
            }
            pre = curr;
            curr = curr.next;
        }
        return node;
    }
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
}
