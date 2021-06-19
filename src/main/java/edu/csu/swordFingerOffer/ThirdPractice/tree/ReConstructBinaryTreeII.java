package edu.csu.swordFingerOffer.ThirdPractice.tree;

import edu.csu.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReConstructBinaryTreeII {

    public static void main(String[] args) {

        int[] pre = new int[]{1,2,3,4,5,6,7};
        int[] in = new int[]{3,2,4,1,6,5,7};
        ReConstructBinaryTreeII obj = new ReConstructBinaryTreeII();
        TreeNode res = obj.reConstructBinaryTree(pre, in);
        System.out.println(res);
    }

    private Map<Integer,Integer> indexMap = new HashMap();
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for(int i = 0;i < in.length;i++){
            indexMap.put(in[i],i);
        }
        return build(pre,0,pre.length - 1,0);
    }

    private TreeNode build(int[] pre,int l,int r,int inL){
        if(l > r) return null;
        TreeNode root = new TreeNode(pre[l]);
        int index = indexMap.get(pre[l]);
        int leftSize = index - l;

        root.left  = build(pre,l + 1,l + leftSize,inL);
        root.right = build(pre,l + leftSize + 1,r,inL + leftSize + 1);
        return root;

    }
}
