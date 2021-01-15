package edu.csu.DataStructure.tree;

import edu.csu.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Connect {
    class Solution {
        public TreeNode connect(TreeNode root) {
            if (root == null) {
                return root;
            }

            // 初始化队列同时将第一层节点加入队列中，即根节点
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);

            // 外层的 while 循环迭代的是层数
            while (!queue.isEmpty()) {

                // 记录当前队列大小
                int size = queue.size();

                // 遍历这一层的所有节点
                for (int i = 0; i < size; i++) {

                    // 从队首取出元素
                    TreeNode node = queue.poll();

                    // 连接
                    if (i < size - 1) {
                        node.next = queue.peek();
                    }

                    // 拓展下一层节点
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            // 返回根节点
            return root;
        }
    }
}
