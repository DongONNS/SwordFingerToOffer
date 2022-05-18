package edu.csu.leetcode.tree;

import edu.csu.TreeNode;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/18 23:51
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;

                root = root.right;
            }
        }
    }
}
