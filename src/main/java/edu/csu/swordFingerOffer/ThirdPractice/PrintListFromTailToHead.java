package edu.csu.swordFingerOffer.ThirdPractice;

import edu.csu.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class PrintListFromTailToHead {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        while(listNode != null){
            stack.push(listNode);
            listNode = listNode.next;
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop().val);
        }
        return res;

        //        ArrayList<Integer> res = new ArrayList();
//        // 判空
//        if (listNode == null) {
//            return res;
//        }
//
//        ListNode dummy = new ListNode(0);
//        ListNode head = listNode;
//        dummy.next = head;
//
//        while (head.next != null) {
//            ListNode next = head.next;
//            head = next;
//            next.next = dummy.next;
//            dummy.next = next;
//        }
//
//        ListNode newHead = dummy.next;
//        while (newHead != null) {
//            res.add(newHead.val);
//            newHead = newHead.next;
//        }
//        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(64);
        ListNode second = new ListNode(0);
        ListNode third = new ListNode(24);
        ListNode fourth = new ListNode(57);
        head.next = second;
        second.next = third;
        third.next = fourth;

        ArrayList<Integer> reverseList = printListFromTailToHead(head);
        System.out.println(Arrays.toString(new ArrayList[]{reverseList}));
    }
}
