package edu.csu.problem26;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        copy(head);
        randomDirect(head);
        return reList(head);

        // Node curr = head;
        // //完成链表的初步复制，将赋值的节点放在我们的我们的当前节点后面
        // while(curr != null){
        //     Node clone = new Node(0);
        //     clone.val = curr.val;
        //     clone.next = head.next;
        //     head.next = clone;
        //     curr = clone.next;
        // }

        // //完成复制节点的随机指针赋值操作
        // curr = head;
        // Node clone = new Node(0);
        // while(curr != null){
        //     clone = head.next;
        //     if(head.random != null){
        //         clone.random = head.random.next;
        //     }
        //     curr = clone.next;
        // }

        // //实现将复制后的链表分开得到我们的目标链表
        // curr = head;
        // Node cloneHead = curr.next;
        // clone = curr.next;
        // curr = curr.next;
        // while(curr != null){
        //     clone.next = curr.next;
        //     clone = clone.next;
        //     curr.next = clone.next;
        //     curr = curr.next;
        // }
        // return cloneHead;
    }
    //实现将我们的子节点全都复制一份，且放在我们的原节点的后面
    private void copy(Node node){
        while(node != null){
            Node clone = new Node(node.val);
            clone.next = node.next;
            node.next = clone;
            node = clone.next;
        }
    }
    //完成复制节点的随即指针定向工作
    private void randomDirect(Node node){
        while(node != null){
            Node cloneNode = node.next;
            if(node.random != null){
                cloneNode.random = node.random.next;
            }
            node = cloneNode.next;
        }
    }
    //将两个链表分开
    private Node reList(Node node){
        Node cloneNode = node.next;
        Node cloneHead = cloneNode;
        node.next = cloneNode.next;
        node = cloneNode.next;
        while(node != null){
            cloneNode.next = node.next;
            node.next = node.next.next;
            node = node.next;
            cloneNode = cloneNode.next;
        }
        return cloneHead;
    }
}

class Node{
    int val;
    Node next;
    Node random;
    Node(int val){
        this.val = val;
    }
}
