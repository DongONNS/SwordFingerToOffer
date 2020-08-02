package edu.csu.DataStructure.LinkedList;

import edu.csu.ListNode;

import javax.swing.*;
import java.util.LinkedList;

public class SplitListToParts {
    public static ListNode[] splitListToParts(ListNode root, int k){
        int count = 0;

        ListNode cur = root;
        //统计节点数量
        while(cur != null){
            count++;
            cur = cur.next;
        }
        //多出来的节点
        int mod = count % k;
        //每个数组应该包含的节点数量
        int size = count / k;

        ListNode[] res = new ListNode[k];
        cur = root;

        for (int i = 0;cur != null && i < k;i++){
            res[i] = cur;
            //获取当前槽位含有的节点数量
            int curSize = size + (mod --> 0 ? 1 : 0);
            for(int j = 0;j < curSize - 1;j++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        root.next  = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode[] res = splitListToParts(root, 5);

    }
}
