package edu.csu.leetcode.list;

import edu.csu.ListNode;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/21 23:41
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode half = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(half);

        ListNode res = new ListNode(-1);
        ListNode curr = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = (left == null) ? right : left;
        return res.next;
    }
}
