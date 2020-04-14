package edu.csu.problem23;

import edu.csu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
    例如:
    给定二叉树: [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    返回其层次遍历结果：
    [
      [3],
      [9,20],
      [15,7]
    ]
 */
public class LevelOrder2 {
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            /*
            这里的for循环应该使用i--而不能使用i++,如果是如下的代码会使得运行出错
            for(int i = 0;i < queue.size();i++){
                doSomething;
            }
            因为我们的queue是会随着元素的弹出不断的发生改变的
             */
            for(int i = queue.size();i > 0;i--){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null)    queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
