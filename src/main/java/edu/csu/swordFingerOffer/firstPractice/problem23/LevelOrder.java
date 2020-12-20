package edu.csu.swordFingerOffer.firstPractice.problem23;

import edu.csu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> array = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            array.add(node.val);
            if(node.left  != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[array.size()];
        for(int i = 0;i < array.size();i++){
            res[i] = array.get(i);
        }
        return res;
    }
}
