package edu.csu.swordFingerOffer.firstPractice.problem45;

public class LastRemaining {
    public int lastRemaining(int n,int m){
        int ans = 0;
        //最后一轮剩下两个人，所以从2开始反推
        for(int i = 2;i <= n;i++){
            ans = (ans+m) % i;
        }
        return ans;
    }
}
