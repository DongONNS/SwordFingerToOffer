package edu.csu.leetcode.Top300;

import edu.csu.ListNode;

public class insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        String deviceId = synthesisDeviceId("19");
        System.out.println(deviceId);
    }

    protected static String synthesisDeviceId(String rawId){
        Integer len = 5;
        // 此处默认的是设备号小于8位，一个园区不存在上百万台设备
        String deviceId = rawId;
        String prefix = "110112000213218";
        for (int i = 0;i < Integer.valueOf(len - rawId.length());i++){
            deviceId = "0" + deviceId;
        }
        deviceId = prefix + deviceId;
        return deviceId;
    }
}
