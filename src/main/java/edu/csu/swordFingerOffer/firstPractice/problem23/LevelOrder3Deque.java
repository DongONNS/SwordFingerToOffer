package edu.csu.swordFingerOffer.firstPractice.problem23;

import edu.csu.TreeNode;

import java.util.*;

public class LevelOrder3Deque {
    public List<List<Integer>> levelOrder(TreeNode root){
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList();
        if (root != null) deque.add(root);
        while(!deque.isEmpty()){
            List<Integer> list = new ArrayList();
            for(int i = deque.size();i>0;i--){
                TreeNode node = deque.removeFirst();
                list.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            res.add(list);
            if (deque.isEmpty()) break;
            list = new ArrayList<Integer>();
            for(int i = deque.size();i > 0;i--){
                TreeNode node = deque.removeLast();
                list.add(node.val);
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            res.add(list);
        }
        return res;
    }
}
