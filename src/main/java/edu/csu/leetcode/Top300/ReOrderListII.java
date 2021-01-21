package edu.csu.leetcode.Top300;

import edu.csu.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReOrderListII {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 找到中间节点
        ListNode middleNode = getMiddleNode(head);
        ListNode l1 = head;
        ListNode l2 = middleNode.next;

        // 分割链表，并将链表后半段逆序
        middleNode.next = null;
        ListNode l2 = reverseList(l2);

        // 合并两段链表
        mergeList(l1,l2);
    }

    /**
     * 合并两段链表
     * @param l1
     * @param l2
     */
    private void mergeList(ListNode l1,ListNode l2){
        ListNode l1Temp;
        ListNode l2Temp;
        while(l1 != null && l2 != null){
            l1Temp = l1.next;
            l2Temp = l2.next;

            l1.next = l2;
            l1 = l1Temp;

            l2.next = l1;
            l2 = l2Temp;
        }
    }

    /**
     * 将链表翻转
     * @param node
     * @return
     */
    private ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode curr = node;

        while(curr != null){
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        return prev;
    }

    /**
     * 获取中间节点
     * @param node
     * @return
     */
    private ListNode getMiddleNode(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
