package edu.csu.DataStructure.tree;

import edu.csu.TreeNode;

public class SumNumber {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root,int prevSum){
        if(root == null){
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        } else{
            return dfs(root.left,sum) + dfs(root.right,sum);
        }

    }
}
