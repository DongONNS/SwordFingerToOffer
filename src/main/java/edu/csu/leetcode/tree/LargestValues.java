package edu.csu.leetcode.tree;

import edu.csu.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class LargestValues {
  public static List<Integer> largestValues(TreeNode root) {
    List<Integer> res = new ArrayList();
    if(root == null) return res;
    dfs(root, 0, res);
    return res;
  }

  private static void dfs(TreeNode root, int depth, List<Integer> res) {
    if(root == null) return ;

    if(depth == res.size()) {
      res.add(Integer.MIN_VALUE);
    }

    res.set(depth, Math.max(res.get(depth), root.val));

    dfs(root.left, depth++, res);
    dfs(root.right, depth++, res);
  }

  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(3);
    TreeNode node3 = new TreeNode(2);
    TreeNode node4 = new TreeNode(5);
    TreeNode node5 = new TreeNode(3);
    TreeNode node6 = new TreeNode(9);

    node1.left = node2;
    node1.right = node3;;

    node2.left = node4;
    node2.right = node5;

    node3.right = node6;

    List<Integer> res = largestValues(node1);
    System.out.println(res);
  }
}
