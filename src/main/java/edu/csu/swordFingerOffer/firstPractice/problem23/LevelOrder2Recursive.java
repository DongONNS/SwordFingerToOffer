package edu.csu.swordFingerOffer.firstPractice.problem23;

import edu.csu.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder2Recursive {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root){
        recur(root,0);
        return res;
    }
    public void recur(TreeNode root,int k){
        if(root != null){
            if(res.size() <= k)
                res.add(new ArrayList());
            res.get(k).add(root.val);
            recur(root.left,k+1);
            recur(root.right,k+1);
        }
    }
}
