package edu.csu.problem50;

import edu.csu.TreeNode;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if (p.val < root.val && q.val < root.val){
                root = lowestCommonAncestor(root.left,p,q);
            }else if (p.val > root.val && q.val > root.val){
                root = lowestCommonAncestor(root.right,p,q);
            }
            break;
        }
        return root;
    }
}
