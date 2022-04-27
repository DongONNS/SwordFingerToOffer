package edu.csu.leetcode.list;

import edu.csu.ListNode;

/**
 * @author dongcheng_2018@163.com
 * @date 2022/4/27 23:52
 */
public class RemoveNthFromEnd {
    /**
     * 删除链表倒数第n个节点.
     * @param head 头节点
     * @param n 倒数第n个节点
     * @return 删除节点后的链表
     */
    public ListNode removeNthFromEnd(final ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode fast = pre;
        ListNode slow = pre;

        while (n-- > 0 && fast != null) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return pre.next;
    }
}
