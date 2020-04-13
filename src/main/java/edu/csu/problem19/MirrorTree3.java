package edu.csu.problem19;

import edu.csu.TreeNode;

import java.util.Stack;
//利用辅助栈完成解题;
public class MirrorTree3 {
    public static TreeNode mirrorTree(TreeNode root){
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
