package edu.csu.swordFingerOffer.ThirdPractice.tree;

import edu.csu.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        // 判空
        if(pre.length == 0 || in.length == 0) return null;

        // 记录中序遍历元素的位置
        Map<Integer,Integer> inMap = new HashMap();
        for(int i = 0;i < in.length;i++){
            inMap.put(in[i],i);
        }

        TreeNode res = reConstruct(pre,0,pre.length-1,in,0,in.length-1,inMap);
        return res;
    }

    public TreeNode reConstruct(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd,Map<Integer,Integer> inMap){
        if(preStart > preEnd){
            return null;
        }

        // 获取根节点的值
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) return root;
        else{
            int rootIndexInorder = inMap.get(rootVal);
            int leftCount = rootIndexInorder - inStart;
            int rightCount = inEnd - rootIndexInorder;

            root.left = reConstruct(pre,preStart + 1,preStart + leftCount,in,inStart,rootIndexInorder - 1,inMap);
            root.right = reConstruct(pre,preEnd - rightCount + 1,preEnd,in,rootIndexInorder + 1,inEnd,inMap);
        }
        return root;
    }
}
