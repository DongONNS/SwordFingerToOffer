package edu.csu.problem5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePrint {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        int[] ints = reversePrint(node1);
        System.out.println(Arrays.toString(ints));
    }
//  辅助栈法
//    public static int[] reversePrint(ListNode head){
//        Stack<ListNode> stack = new Stack<ListNode>();
//        ListNode curr = head;
//        while(curr != null){
//            stack.push(curr);
//            curr = curr.next;
//        }
//        int size = stack.size();
//        int[] print = new int[size];
//        for (int i = 0;i < size;i++){
//            print[i] = stack.pop().val;
//        }
//        return print;
//    }

//   递归解法
    static List<Integer> list = new ArrayList<Integer>();
    public static int[] reversePrint(ListNode head){
        recur(head);
        int[] res = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    static void recur(ListNode head){
        if(head == null) return;
        recur(head.next);
        list.add(head.val);
    }


//    public static int[] reversePrint(ListNode head){
//        int[] nullArr = new int[0];
//        if (head == null) return nullArr;
//        List<Integer> list = new ArrayList<Integer>();
//        ListNode curr = head;
//        while(curr != null){
//            list.add(curr.val);
//            curr = curr.next;
//        }
//        int[] ans = new int[list.size()];
//        int len = list.size()-1;
//        int index = 0;
//        while(len>=0){
//            ans[index++] = list.get(len--);
//        }
//        return ans;
//    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        this.val = x;
    }
}
