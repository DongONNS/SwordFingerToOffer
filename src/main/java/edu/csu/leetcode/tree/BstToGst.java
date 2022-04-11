package edu.csu.leetcode.tree;

import edu.csu.TreeNode;

public class BstToGst {
  private static int sum = 0;
  private static int sub = 0;

  public static TreeNode bstToGst(TreeNode root) {
    TreeNode temp = root;
    before(temp, 0);
    System.out.println(sum);

    temp = root;
    before(temp, 1);
    System.out.println(sum);
    return root;
  }

  /**
   * root： 当前节点
   * type: 遍历操作的类型 0-加和 1-改变树中节点值
   */
  private static void before(TreeNode root, int type){
    if(root == null) return;
    before(root.left, type);
    if(type == 0) {
      sum += root.val;
    } else {
      int temp = root.val;
      root.val = sum - sub;
      sub += temp;
    }
    before(root.right, type);
  }

  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(4);
    TreeNode node2 = new TreeNode(1);
    TreeNode node3 = new TreeNode(6);
    TreeNode node4 = new TreeNode(0);
    TreeNode node5 = new TreeNode(2);
    TreeNode node6 = new TreeNode(5);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(3);
    TreeNode node9 = new TreeNode(8);

    node1.left = node2;
    node1.right = node3;

    node2.left = node4;
    node2.right = node5;

    node3.left = node6;
    node3.right = node7;

    node5.right = node8;

    node7.right = node9;

    bstToGst(node1);
  }
}
