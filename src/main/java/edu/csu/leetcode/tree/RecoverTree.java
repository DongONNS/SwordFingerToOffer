package edu.csu.leetcode.tree;

import edu.csu.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 恢复二叉搜索树.
 */
public class RecoverTree {

  /**
   * 恢复二叉搜索树.

   * @param root 根节点
   */
  public void recoverTree(TreeNode root) {
    List<TreeNode> list = new ArrayList();
    TreeNode first = null;
    TreeNode second = null;

    mid(root, list);

    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i).val > list.get(i + 1).val) {
        second = list.get(i + 1);
        if (first == null) {
          first = list.get(i);
        }
      }
    }

    if (first != null && second != null) {
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
    }
  }

  private void mid(TreeNode root, List<TreeNode> list) {
    if (root == null) {
      return;
    }
    mid(root.left, list);
    list.add(root);
    mid(root.right, list);
  }
}
