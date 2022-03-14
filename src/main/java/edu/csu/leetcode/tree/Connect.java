package edu.csu.leetcode.tree;

/**
 * 填充每个节点的下一个右侧节点指针.
 */
public class Connect {

  /**
   * 将一颗完美二叉树同层进行指向.

   * @param root 根节点
   * @return 连接结果
   */
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }

    Node pre = root;
    while (pre.left != null) {
      Node temp = pre;
      while (temp != null) {
        temp.left.next = temp.right;
        if (temp.next != null) {
          temp.right = temp.next.left;
        }
        temp = temp.next;
      }
      pre = pre.left;
    }
    return root;
  }

  private class Node {
    int val;
    Node left;
    Node right;
    Node next;
  }
}
