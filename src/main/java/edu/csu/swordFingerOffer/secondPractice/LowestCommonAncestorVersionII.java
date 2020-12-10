package edu.csu.swordFingerOffer.secondPractice;

import edu.csu.TreeNode;

public class LowestCommonAncestorVersionII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null ){
            return root;
        }

        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
