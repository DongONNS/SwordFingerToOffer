package edu.csu.swordFingerOffer.ThirdPractice.tree;

import edu.csu.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class PrintZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(pRoot == null) return res;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(pRoot);
        boolean reverse = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> path = new ArrayList();
            while(size-- > 0){
                TreeNode node = queue.poll();
                path.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(reverse){
                Collections.reverse(path);
            }
            reverse = !reverse;
            res.add(new ArrayList(path));
        }
        return res;
    }
}
