package edu.csu.swordFingerOffer.problem6;

import java.util.HashMap;
import java.util.Map;

//根据前序遍历和中序遍历的结果重建一棵二叉树
public class BuildTree {
    public TreeNode buildTree(int[] preOrder,int[] inOrder){
        if (preOrder==null||inOrder==null) return null;
        Map<Integer,Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0;i < preOrder.length;i++){
            indexMap.put(inOrder[i],i);
        }
        TreeNode treeNode = constructTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, indexMap);
        return treeNode;
    }
    public TreeNode constructTree(int[] preOrder,int ps,int pe,int[] inOrder,int is,int ie,Map<Integer,Integer> indexMap){
        if (ps > pe) return null;
        int value = preOrder[ps];
        TreeNode node = new TreeNode(value);
        if (ps == pe) return node;
        else{
            int rootIndex = indexMap.get(value);
            int leftNodeCount = rootIndex-is,rightNodeCount = ie - rootIndex;
            node.left = constructTree(preOrder,ps+1,ps+leftNodeCount,inOrder,is,rootIndex-1,indexMap);
            node.right = constructTree(preOrder,pe-rootIndex+1,pe,inOrder,rootIndex+1,ie,indexMap);
        }
        return node;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
