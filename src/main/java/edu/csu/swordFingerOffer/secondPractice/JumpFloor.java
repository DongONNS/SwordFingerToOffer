package edu.csu.swordFingerOffer.secondPractice;

public class JumpFloor {
    public int jumpFloor(int n) {
        //
        if(n <=2)  return n;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for(
                int i = 2;
                i<n;i++)

        {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
