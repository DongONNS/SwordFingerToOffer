package edu.csu.problem37;

import edu.csu.ListNode;

import java.util.Stack;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int totalA = 0;
        ListNode tmpA = headA;
        while(tmpA!=null){
            totalA++;
            tmpA = tmpA.next;
        }
        int totalB = 0;
        ListNode tmpB = headB;
        while(tmpA != null){
            totalB++;
            tmpB = tmpB.next;
        }
        if (totalA > totalB){
            int diff = totalA - totalB;
            while(diff>0){
                headA = headA.next;
                diff--;
            }
        }else{
            int diff = totalB - totalA;
            while(diff > 0){
                headB = headB.next;
                diff--;
            }
        }
        while(headA!=null && headB!=null){
            if (headA == headB){
                return headA;
            }else{
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}


//public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//    Stack<ListNode> stackA = new Stack();
//    Stack<ListNode> stackB = new Stack();
//    while(headA != null){
//        stackA.add(headA);
//        headA = headA.next;
//    }
//    while(headB != null){
//        stackB.add(headB);
//        headB = headB.next;
//    }
//    ListNode pre = null;
//    while(!stackA.isEmpty() && !stackB.isEmpty()){
//        ListNode nodeA = stackA.pop();
//        ListNode nodeB = stackB.pop();
//        if(nodeA != nodeB) return pre;
//        pre = nodeA;
//    }
//    return null;
//}
