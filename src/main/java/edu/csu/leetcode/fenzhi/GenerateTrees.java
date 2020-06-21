package edu.csu.leetcode.fenzhi;

import edu.csu.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class GenerateTrees {
    class Solution{
        public List<TreeNode> generateTrees(int n){
            if(n < 1)
                return new LinkedList<TreeNode>();
            return generateSubTrees(1,n);
        }

        //生成子树
        private List<TreeNode> generateSubTrees(int start ,int end){
            //存储结果
            List<TreeNode> res = new LinkedList<TreeNode>();

            //如果[start,end]区间错误，直接添加null
            if(start > end){
                res.add(null);
                return res;
            }

            for(int i = start;i <= end;i++){
                List<TreeNode> left  = generateSubTrees(start,i - 1);
                List<TreeNode> right = generateSubTrees(i + 1,end);
                for(TreeNode l : left){
                    for(TreeNode r : right){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
            return res;
        }
    }
}
