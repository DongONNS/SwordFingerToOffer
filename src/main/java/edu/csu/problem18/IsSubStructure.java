package edu.csu.problem18;

import edu.csu.TreeNode;
//给定两棵树，判断B树是否是A树的子树;
public class IsSubStructure {
    public static boolean isSubStructure(TreeNode A, TreeNode B){
        boolean result = false;
        if (A!=null && B!=null){
            if (A.val == B.val)
                result = doesTreeAHassTreeB(A,B);
            if (!result)
                result = isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }
        return result;
    }
    public static boolean doesTreeAHassTreeB(TreeNode A,TreeNode B){
        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val) return false;
        return doesTreeAHassTreeB(A.left,B.left)&&doesTreeAHassTreeB(A.right,B.right);
    }
}
