package edu.csu.swordFingerOffer.firstPractice.problem19;

import edu.csu.TreeNode;
//同样是镜像树，但是感觉这样写更符合递归，递归中我们只需要控制好当前的过程和递归的终止条件
public class MirrorTree2 {
    public static TreeNode mirrorTree(TreeNode root){
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(temp);
        return root;
    }
}
