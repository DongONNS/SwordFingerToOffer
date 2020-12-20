package edu.csu.swordFingerOffer.firstPractice.problem50;

import edu.csu.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val){
            return root = lowestCommonAncestor(root.left,p,q);
        }
        if (p.val > root.val && q.val > root.val){
            return root = lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
