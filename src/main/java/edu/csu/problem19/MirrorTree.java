package edu.csu.problem19;

import edu.csu.TreeNode;
//输入一棵树，然后输出这棵树的镜像;
public class MirrorTree {
    public static TreeNode mirrorTree(TreeNode root){
        if (root==null ||(root.left==null && root.right==null)) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) mirrorTree(root.left);
        if (root.right != null) mirrorTree(root.right);
        return root;
    }
}
