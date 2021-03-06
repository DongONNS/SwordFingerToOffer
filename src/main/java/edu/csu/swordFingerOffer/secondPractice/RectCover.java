package edu.csu.swordFingerOffer.secondPractice;

public class RectCover {
    public int RectCover(int target) {
        if(target <= 2) return target;
        int pre2 = 1,pre1 = 2;
        int result = 0;

        for(int i = 3;i <= target;i++){
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
