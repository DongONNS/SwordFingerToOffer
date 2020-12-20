package edu.csu.swordFingerOffer.firstPractice.problem;

//输出链表的倒数第K个节点
//显然使用双指针法
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
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
