package edu.csu.swordFingerOffer.ThirdPractice.tree;

import edu.csu.TreeNode;

import java.util.ArrayList;

public class FindPath {

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(4 );
        TreeNode node4 = new TreeNode(7 );

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        ArrayList<ArrayList<Integer>> res = FindPath(root, 22);
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(root == null) return res;
        dfs(root,target,new ArrayList(),res);
        return res;
    }

    private static void dfs(TreeNode root,int target,ArrayList path,ArrayList<ArrayList<Integer>> res){
        if(root == null) return;

        path.add(root.val);
        target -= root.val;

        // 递归终止条件
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList(path));
        } else {
            dfs(root.left,target,path,res);
            dfs(root.right,target,path,res);
        }
        path.remove(path.size() - 1);
    }
}
