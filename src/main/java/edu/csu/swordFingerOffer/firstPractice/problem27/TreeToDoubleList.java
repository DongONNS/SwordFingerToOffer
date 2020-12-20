package edu.csu.swordFingerOffer.firstPractice.problem27;

import edu.csu.TreeNode;

//将一棵二叉搜索树转换成双向链表
public class TreeToDoubleList {
    TreeNode head,pre;
    public TreeNode treeToDoubleList(TreeNode root){
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void dfs(TreeNode curr){
        if (curr == null) return;
        dfs(curr.left);
        if(pre == null) head = curr;//如果前驱节点为空，那说明当前节点是头节点
        else pre.right = curr;
        curr.left = pre;
        pre = curr;
        dfs(curr.right);
    }
}
