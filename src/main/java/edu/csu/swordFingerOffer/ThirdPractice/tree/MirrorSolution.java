package edu.csu.swordFingerOffer.ThirdPractice.tree;

import edu.csu.TreeNode;

public class MirrorSolution {
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot == null) return null;
        if(pRoot.left == null && pRoot.right == null){
            return pRoot;
        }
        // 交换左右子节点
        TreeNode tmp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = tmp;

        if(pRoot.left != null){
            Mirror(pRoot.left);
        }
        if(pRoot.right != null){
            Mirror(pRoot.right);
        }
        return pRoot;
    }
}
