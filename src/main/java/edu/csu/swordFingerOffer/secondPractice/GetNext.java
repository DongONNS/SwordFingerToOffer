package edu.csu.swordFingerOffer.secondPractice;

import edu.csu.TreeLinkNode;

public class GetNext {
    public TreeLinkNode getNext(TreeLinkNode pNode){
        // 如果当前节点的右子树不为空，那么找到右子数的最左节点就是下一个节点
        if (pNode.right != null){
            TreeLinkNode node = pNode.right;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }else{
            // 否则找到当前节点所在左子数的父节点
            while(pNode.next != null){
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode){
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }
}
