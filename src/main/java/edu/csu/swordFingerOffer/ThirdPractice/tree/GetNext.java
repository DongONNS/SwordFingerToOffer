package edu.csu.swordFingerOffer.ThirdPractice.tree;

import edu.csu.TreeLinkNode;

public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null) return pNode;
        // 如果当前节点的右节点不为空，那么直接返回右子节点
        if(pNode.right != null){
            return pNode.right;
        }else{
            TreeLinkNode parent = pNode.next;
            while(pNode != parent.left){
                pNode = parent;
                parent = pNode.next;
            }
            return parent;
        }
    }
}
