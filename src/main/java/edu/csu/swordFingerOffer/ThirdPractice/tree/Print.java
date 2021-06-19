package edu.csu.swordFingerOffer.ThirdPractice.tree;

import edu.csu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList();
            while(size-- > 0){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left  != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(new ArrayList(level));
        }
        return res;
    }
}
