package edu.csu.swordFingerOffer.secondPractice;

import edu.csu.TreeNode;

import java.util.ArrayList;

public class FindPath {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        backTracking(root,target,new ArrayList());
        return ret;
    }

    private void backTracking(TreeNode node,int target,ArrayList<Integer> path){
        if (node == null){
            return;
        }

        // 添加根节点
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null){
            ret.add(new ArrayList<>(path));
        }else{
            backTracking(node.left,target,path);
            backTracking(node.right,target,path);
        }
        path.remove(path.size() - 1);
    }
}
