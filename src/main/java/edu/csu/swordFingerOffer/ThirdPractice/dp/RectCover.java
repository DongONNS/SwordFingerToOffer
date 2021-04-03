package edu.csu.swordFingerOffer.ThirdPractice.dp;

public class RectCover {
    public int rectCover(int target){
        if (target < 2)
            return target;

        int pre2 = 1,pre1 = 1;
        int sum = pre1 + pre2;

        for (int i = 2;i <= target;i++){
            sum = pre1 + pre2;
            pre2 = pre1;
            pre1 = sum;
        }
        return sum;
    }
}
