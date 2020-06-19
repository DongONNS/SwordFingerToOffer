package edu.csu.swordFingerOffer.problem23;

import edu.csu.TreeNode;

import java.util.*;

public class LevelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            for(int i = queue.size() ;i > 0;i--){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(res.size() %2 ==1) Collections.reverse(list);
            res.add(list);
        }
        return res;
    }
}
