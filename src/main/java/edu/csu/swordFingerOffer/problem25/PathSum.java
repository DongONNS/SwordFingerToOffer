package edu.csu.swordFingerOffer.problem25;

import edu.csu.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PathSum {
    LinkedList<List<Integer>> res = new LinkedList();
    LinkedList<Integer> list = new LinkedList();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        dfs(root,sum);
        return res;
    }
    public void dfs(TreeNode root,int sum){
        if(root == null) return;
        sum -= root.val;
        list.add(root.val);
        if (sum == 0 && root.left ==null && root.right == null){
            res.add(new LinkedList(list));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        list.removeLast();
    }
}
