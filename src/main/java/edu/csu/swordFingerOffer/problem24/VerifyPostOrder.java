package edu.csu.swordFingerOffer.problem24;

public class VerifyPostOrder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length - 1);
    }
    private boolean recur(int[] postorder,int left,int right){
        if(left >= right) return true;
        int point = left;
        while(postorder[point] < postorder[right]) point++;
        int part = point;
        while(postorder[point] > postorder[right]) point++;
        return point==right && recur(postorder,left,part-1) && recur(postorder,part,point-1);
    }
}
