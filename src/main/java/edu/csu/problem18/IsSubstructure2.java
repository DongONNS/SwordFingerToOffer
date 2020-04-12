package edu.csu.problem18;

import edu.csu.TreeNode;

public class IsSubstructure2 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return doesTreeAHasTreeB(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    public boolean doesTreeAHasTreeB(TreeNode A,TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        return A.val==B.val && doesTreeAHasTreeB(A.left,B.left) && doesTreeAHasTreeB(A.right,B.right);
    }
}
