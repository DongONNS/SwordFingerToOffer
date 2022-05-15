package edu.csu.leetcode.tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import edu.csu.TreeNode;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/15 22:30
 */
public class IsValidBST {

    private static long pre = Long.MIN_VALUE;
    private static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(7);
        node3.left = node4;
        node3.right = node5;
        node1.left = node2;
        node1.right = node2;
        boolean res = isValidBST(node1);
        System.out.println(res);
    }
}
